package com.jd.jdda_collector.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 * User: tibelf
 * Date: 14-9-15
 * Time: 下午1:49
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class MetricCollectorServiceImplTest {
    @Resource
    private MetricCollectorServiceImpl metricCollectorService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParserAndSave() throws Exception {
//        metricCollectorService.parserAndSave("[1152815361,1410444727.3270397,1410444787.862891,[[{\"name\": \"Supportability/invoke_remote\",\"scope\": \"\"}" +
//                ",[3,1.6520358910000001,1.6520358910000001,0.534835803,0.560544413,0.910124915625875]]," +
//                "[{\"name\": \"Supportability/invoke_remote\",\"scope\": \"\"}" +
//                ",[3,1.6520358910000001,1.6520358910000001,0.534835803,0.560544413,0.910124915625875]]]]");
        metricCollectorService.parserAndSave("[15,1410849830.578425,1410850027.521948,[[{\"scope\":\"\",\"name\":\"Supportability/Harvest/Calls/harvest\"},[1,0.024487018585205078,0.024487018585205078,0.024487018585205078,0.024487018585205078,0.0005996140791921789]],[{\"scope\":\"\",\"name\":\"Supportability/Harvest/Counts/metric_data\"}," +
                "[1,12.0,12.0,12.0,12,144.0]],[{\"scope\":\"\",\"name\":\"Instance/Reporting\"},[1,0.0,0.0,0.0,0.0,0.0]],[{\"scope\":\"\",\"name\":\"Supportability/Collector/JSON/Encode/metric_data\"},[1,0.0006630420684814453,0.0006630420684814" +
                "453,0.0006630420684814453,0.0006630420684814453,4.396247845761536e-07]],[{\"scope\":\"\",\"name\":\"CPU/User/Utilization\"},[1,0.0005901716484734161,0.0005901716484734161,0.0005901716484734161,0.0005901716484734161,3.48" +
                "3025746618295e-07]],[{\"scope\":\"\",\"name\":\"Supportability/RequestSampler/samples\"},[1,0.0,0.0,0.0,0.0,0.0]],[{\"scope\":\"\",\"name\":\"Supportability/StatsEngine/Calls/metric_data\"},[1,6.4849853515625e-05,6.484985351562" +
                "5e-05,6.4849853515625e-05,6.4849853515625e-05,4.20550350099802e-09]],[{\"scope\":\"\",\"name\":\"CPU/User Time\"},[1,0.040000000000000036,0.040000000000000036,0.040000000000000036,0.040000000000000036,0.0016000000000000" +
                "03]],[{\"scope\":\"\",\"name\":\"Supportability/Collector/Calls/metric_data\"},[1,0.021631956100463867,0.021631956100463867,0.021631956100463867,0.021631956100463867,0.0004679415247323959]],[{\"scope\":\"\",\"name\":\"Supporta" +
                "bility/RequestSampler/requests\"},[1,0.0,0.0,0.0,0.0,0.0]],[{\"scope\":\"\",\"name\":\"Supportability/Collector/Output/Bytes/metric_data\"},[1,1597.0,1597.0,1597.0,1597,2550409.0]],[{\"scope\":\"\",\"name\":\"Memory/Physical\"}," +
                "[1,37.49609375,37.49609375,37.49609375,37.49609375,1405.957046508789]]]]");
    }
}
