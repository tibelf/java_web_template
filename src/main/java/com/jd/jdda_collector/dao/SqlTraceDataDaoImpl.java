package com.jd.jdda_collector.dao;

import com.jd.jdda_collector.model.SqlTraceData;
import com.jd.jdda_collector.mybatis.mapper.SqlTraceDataMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-15
 * Time: 下午5:41
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class SqlTraceDataDaoImpl implements SqlTraceDataDao {
    @Resource
    private SqlTraceDataMapper sqlTraceDataMapper;
    @Override
    public void add(SqlTraceData sqlTraceData) {
        sqlTraceDataMapper.add(sqlTraceData);
    }
}
