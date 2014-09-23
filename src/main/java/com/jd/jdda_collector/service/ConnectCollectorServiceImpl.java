package com.jd.jdda_collector.service;

import com.jd.jdda_collector.common.JsonUtil;
import com.jd.jdda_collector.dao.ApplicationDaoImpl;
import com.jd.jdda_collector.model.Application;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 上午11:37
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ConnectCollectorServiceImpl implements CollectorService {
    @Resource
    private ApplicationDaoImpl applicationDao;

    private Long agetId;

    @Override
    public void parserAndSave(String data, String... args) throws Exception {
        Object[] array = JsonUtil.convertJsonToClass(data, Object[].class);
        HashMap infoMap = (HashMap) array[0];
        if (infoMap.get("app_name") != null) {
            Application application = new Application();
            List nameList = (List) infoMap.get("app_name");
            if (nameList.size() > 0) {
                application.setName(nameList.get(0).toString());
            }
            agetId = applicationDao.getId(application.getName());
            if (agetId == null)
            {
                applicationDao.add(application);
                agetId = application.getId();
            }
        }
    }

    public Long getAgetId() {
        return agetId;
    }
}
