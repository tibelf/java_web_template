package com.jd.jdda_collector.dao;

import com.jd.jdda_collector.model.Application;
import com.jd.jdda_collector.mybatis.mapper.ApplicationMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 下午1:15
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class ApplicationDaoImpl implements ApplicationDao {
    @Resource
    private ApplicationMapper applicationMapper;

    @Override
    public void add(Application application) {
        applicationMapper.add(application);
    }

    @Override
    public Long getId(String name) {
        return applicationMapper.getId(name);
    }
}
