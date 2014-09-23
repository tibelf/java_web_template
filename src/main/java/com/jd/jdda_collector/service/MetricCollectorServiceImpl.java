package com.jd.jdda_collector.service;

import com.jd.jdda_collector.common.JsonUtil;
import com.jd.jdda_collector.dao.MetricDataDaoImpl;
import com.jd.jdda_collector.model.MetricData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by tibelf on 9/15/14.
 */
@Service
public class MetricCollectorServiceImpl implements CollectorService {
    @Resource
    private MetricDataDaoImpl metricDataDao;

    private void parseMetricData(List list, MetricData metricData) {
        for (int i = 0; i < list.size(); i ++) {
            if (list.get(i) instanceof HashMap) {
                HashMap map = (HashMap) list.get(i);
                metricData.setName(map.get("name").toString());
                if (map.get("scope") != null)
                    metricData.setScope(map.get("scope").toString());
            }
            else {
                List paramsList = (List) list.get(i);
                if (paramsList.get(0) != null)
                    metricData.setCallCount(Integer.valueOf(paramsList.get(0).toString()));
                if (paramsList.get(1) != null)
                    metricData.setTotalCallTime(Double.valueOf(paramsList.get(1).toString()));
                if (paramsList.get(2) != null)
                    metricData.setTotalExclusiveTime(Double.valueOf(paramsList.get(2).toString()));
                if (paramsList.get(3) != null)
                    metricData.setMinCallTime(Double.valueOf(paramsList.get(3).toString()));
                if (paramsList.get(4) != null)
                    metricData.setMaxCallTime(Double.valueOf(paramsList.get(4).toString()));
                if (paramsList.get(5) != null)
                    metricData.setSumOfsquares(Double.valueOf(paramsList.get(5).toString()));
            }
        }
    }
    @Override
    public void parserAndSave(String data, String... args) throws Exception {
        List<MetricData> metricDataList = new ArrayList<MetricData>();
        MetricData metricData = new MetricData();
        Object[] objectArray = JsonUtil.convertJsonToClass(data, Object[].class);
        if (objectArray.length == 4) {
            metricData.setAgentId(objectArray[0].toString());
            metricData.setTimesliceStart(Double.valueOf(objectArray[1].toString()));
            metricData.setTimesliceEnd(Double.valueOf(objectArray[2].toString()));
            List metricDataArray = (List) objectArray[3];
            for (int i = 0; i < metricDataArray.size(); i ++) {
                if (metricDataArray.get(i) instanceof ArrayList) {
                    MetricData pMetricData = metricData.clone();
                    parseMetricData((List) metricDataArray.get(i), pMetricData);
                    metricDataList.add(pMetricData);
                }
            }
        }
        for (int i = 0; i < metricDataList.size(); i ++) {
            metricDataDao.add(metricDataList.get(i));
        }
    }
}
