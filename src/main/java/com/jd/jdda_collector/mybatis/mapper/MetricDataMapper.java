package com.jd.jdda_collector.mybatis.mapper;

import com.jd.jdda_collector.model.MetricData;
import org.springframework.stereotype.Repository;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-15
 * Time: 下午2:55
 * To change this template use File | Settings | File Templates.
 */
//@Repository
public interface MetricDataMapper {
    public int add(MetricData metricData);
}
