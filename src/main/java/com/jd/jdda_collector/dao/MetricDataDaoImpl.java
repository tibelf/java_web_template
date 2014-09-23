package com.jd.jdda_collector.dao;

import com.jd.jdda_collector.model.MetricData;
import com.jd.jdda_collector.mybatis.mapper.MetricDataMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;


/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-15
 * Time: 下午3:08
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class MetricDataDaoImpl implements MetricDataDao {
    @Resource
    private MetricDataMapper metricDataMapper;

    @Override
    public void add(MetricData metricData) {
        metricDataMapper.add(metricData);
    }
}
