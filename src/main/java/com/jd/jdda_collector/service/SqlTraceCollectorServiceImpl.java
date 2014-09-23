package com.jd.jdda_collector.service;

import com.jd.jdda_collector.common.JsonUtil;
import com.jd.jdda_collector.dao.SqlTraceDataDaoImpl;
import com.jd.jdda_collector.model.SqlTraceData;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by tibelf on 9/15/14.
 */
@Service
public class SqlTraceCollectorServiceImpl implements CollectorService {
    @Resource
    private SqlTraceDataDaoImpl sqlTraceDataDao;

    private SqlTraceData parseSqlTraceData(List list) {
        SqlTraceData sqlTraceData = new SqlTraceData();
        sqlTraceData.setPath(list.get(0).toString());
        sqlTraceData.setUrl(list.get(1).toString());
        sqlTraceData.setSqlId(list.get(2).toString());
        sqlTraceData.setSql(list.get(3).toString());
        sqlTraceData.setDatabaseMetricName(list.get(4).toString());
        sqlTraceData.setCallCount(Integer.valueOf(list.get(5).toString()));
        sqlTraceData.setTotalCallTime(Integer.valueOf(list.get(6).toString().split("\\.")[0]));
        sqlTraceData.setMinCallTime(Integer.valueOf(list.get(7).toString().split("\\.")[0]));
        sqlTraceData.setMaxCallTime(Integer.valueOf(list.get(8).toString().split("\\.")[0]));
        if (list.get(9) instanceof HashMap) {
            HashMap map = (HashMap) list.get(9);
            sqlTraceData.setBackTrace(map.get("backtrace").toString());
        }
        return sqlTraceData;
    }
    @Override
    public void parserAndSave(String data, String... args) throws Exception {
        List<SqlTraceData> sqlTraceDataList = new ArrayList<SqlTraceData>();
        Object[] objectArray = JsonUtil.convertJsonToClass(data, Object[].class);
        if (objectArray.length == 1) {
            List sqlTraceDataArray = (List) objectArray[0];
            for (int i = 0; i < sqlTraceDataArray.size(); i ++) {
                if (sqlTraceDataArray.get(i) instanceof ArrayList) {
                    SqlTraceData sqlTraceData = parseSqlTraceData((List) sqlTraceDataArray.get(i));
                    sqlTraceData.setAgentId(args[0]);
                    sqlTraceDataList.add(sqlTraceData);
                }
            }
        }
        for (int i = 0; i < sqlTraceDataList.size(); i ++) {
            sqlTraceDataDao.add(sqlTraceDataList.get(i));
        }
    }
}
