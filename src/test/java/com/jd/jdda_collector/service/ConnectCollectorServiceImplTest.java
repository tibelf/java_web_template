package com.jd.jdda_collector.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-16
 * Time: 下午1:20
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class ConnectCollectorServiceImplTest {
    @Resource
    private ConnectCollectorServiceImpl connectCollectorService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParserAndSave() throws Exception {
        connectCollectorService.parserAndSave("[{\"pid\":10685,\"host\":\"tibelf-Lenovo-IdeaPad-Y470\",\"app_name\":[\"My Application (Development)1\"]}]");
        System.out.println(connectCollectorService.getAgetId());
    }
}
