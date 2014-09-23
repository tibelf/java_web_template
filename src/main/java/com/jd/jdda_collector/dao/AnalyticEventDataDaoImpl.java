package com.jd.jdda_collector.dao;

import com.jd.jdda_collector.model.AnalyticEventData;
import com.jd.jdda_collector.mybatis.mapper.AnalyticEventDataMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 上午9:49
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class AnalyticEventDataDaoImpl implements AnalyticEventDataDao {
    @Resource
    private AnalyticEventDataMapper analyticEventDataMapper;

    @Override
    public void add(AnalyticEventData analyticEventData) {
        analyticEventDataMapper.add(analyticEventData);
    }
}
