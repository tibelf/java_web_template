package com.jd.jdda_collector.service;

import com.jd.jdda_collector.common.JsonUtil;
import com.jd.jdda_collector.common.ObjectUtil;
import com.jd.jdda_collector.dao.AnalyticEventDataDaoImpl;
import com.jd.jdda_collector.model.AnalyticEventData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 上午9:41
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AnalyticEventCollectorServiceImpl implements CollectorService {
    @Resource
    private AnalyticEventDataDaoImpl analyticEventDataDao;

    private final Map<String, String> properties = new HashMap<String, String>(){
        {
            put("databaseCallCount", null);
            put("databaseDuration", null);
            put("duration", null);
            put("name", null);
            put("nrGuid", null);
            put("nr.referringTransactionGuid", "nrReferringTransactionGuid");
            put("nr.tripId", "nrTripId");
            put("nr.pathHash", "nrPathHash");
            put("nr.referringPathHash", "nrReferringPathHash");
            put("nr.alternatePathHashes", "nrAlternatePathHashes");
            put("nr.apdexPerfZone", "nrApdexPerfZone");
            put("timestamp", null);
            put("type", null);
        }
    };

    private AnalyticEventData parseAnalyticEventData(List list) {
        AnalyticEventData analyticEventData = new AnalyticEventData();
        if (list.size() == 2) {
            HashMap analyticEventDataMap = (HashMap) list.get(0);
            ObjectUtil.copyProperties(analyticEventDataMap, analyticEventData, properties);
        }
        return analyticEventData;
    }

    @Override
    public void parserAndSave(String data, String... args) throws Exception {
        List<AnalyticEventData> analyticEventDataArrayList = new ArrayList<AnalyticEventData>();
        Object[] objectArray = JsonUtil.convertJsonToClass(data, Object[].class);
        if (objectArray.length == 2) {
            List analyticEventDataArray = (List) objectArray[1];
            for (int i = 0; i < analyticEventDataArray.size(); i ++) {
                if (analyticEventDataArray.get(i) instanceof ArrayList) {
                    AnalyticEventData analyticEventData = parseAnalyticEventData((List) analyticEventDataArray.get(i));
                    analyticEventData.setAgentId(objectArray[0].toString());
                    analyticEventDataArrayList.add(analyticEventData);
                }
            }
        }
        for (int i = 0; i < analyticEventDataArrayList.size(); i ++) {
            analyticEventDataDao.add(analyticEventDataArrayList.get(i));
        }
    }
}
