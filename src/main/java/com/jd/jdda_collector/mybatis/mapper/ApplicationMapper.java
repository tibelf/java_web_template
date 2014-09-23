package com.jd.jdda_collector.mybatis.mapper;

import com.jd.jdda_collector.model.Application;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 下午1:15
 * To change this template use File | Settings | File Templates.
 */
public interface ApplicationMapper {
    public int add(Application application);
    public Long getId(String name);
}
