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
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class AnalyticEventCollectorServiceImplTest {
    @Resource
    private AnalyticEventCollectorServiceImpl analyticEventCollectorService;
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testParserAndSave() throws Exception {
//        analyticEventCollectorService.parserAndSave("[1152815361,[" +
//                "[" +
//                "{\"databaseCallCount\": 4,\"databaseDuration\": 0.004540681838989258,\"duration\": 0.15635085105895996," +
//                "\"name\": \"Controller/products/index\",\"nr.apdexPerfZone\": \"S\",\"timestamp\": 1410444733.3551621,\"type\": \"Transaction\"},{}" +
//                "]," +
//                "[" +
//                "{\"databaseCallCount\": 4,\"databaseDuration\": 0.004540681838989258,\"duration\": 0.15635085105895996,"+
//                "\"name\": \"Controller/products/index\",\"nr.apdexPerfZone\": \"S\",\"timestamp\": 1410444733.3551621,\"type\": \"Transaction\"},{}" +
//                "]" +
//                "]]");
        analyticEventCollectorService.parserAndSave(
                "[47,[[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011095525,\"databaseDuration\":null,\"duration\":0.87132007,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Initializer\\/ServletContextListener\\/org.springframework.web.context.ContextLoaderListener\\/contextInitialized\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011116503,\"databaseDuration\":null,\"duration\":2.13783E-4,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Java\\/org.eclipse.jetty.servlet.DefaultServlet\\/init\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011116504,\"databaseDuration\":null,\"duration\":1.29821E-4,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Java\\/org.eclipse.jetty.servlet.NoJspServlet\\/init\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011116534,\"databaseDuration\":null,\"duration\":0.68761665,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Java\\/org.springframework.web.servlet.DispatcherServlet\\/init\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port" +
                        "\":8080,\"timestamp\":1411011118602,\"databaseDuration\":null,\"duration\":0.7860296,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Initializer\\/ServletContextListener\\/org.springframework.web.c" +
                        "ontext.ContextLoaderListener\\/contextInitialzed\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011119453,\"databaseDuration\":null,\"duration\":1.92597E-4,\"externalDuration\":null,\"queueDu" +
                        "ration\":null,\"name\":\"OtherTransaction\\/Java\\/org.eclipse.jetty.servlet.DefaultServlet\\/init\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011119454,\"databaseDuration\":null,\"duration\":" +
                        "1.17185E-4,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Java\\/org.eclipse.jetty.servlet.NoJspServlet\\/init\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":14110111" +
                        "19503,\"databaseDuration\":null,\"duration\":0.6213476,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Java\\/org.springframework.web.servlet.DispatcherServlet\\/init\",\"type\":\"Transaction\"}],[{\"" +
                        "gcCumulative\":null,\"port\":8080,\"timestamp\":1411011120140,\"databaseDuration\":null,\"duration\":2.41457E-4,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransaction\\/Java\\/org.eclipse.jetty.servlet.Defau" +
                        "ltServlet\\/init\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011120141,\"databaseDuration\":null,\"duration\":1.55107E-4,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"OtherTransac" +
                        "tion\\/Java\\/org.eclipse.jetty.servlet.NoJspServlet\\/init\",\"type\":\"Transaction\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011134361,\"databaseDuration\":null,\"duration\":0.0235909,\"externalDuration\":null,\"" +
                        "queueDuration\":null,\"name\":\"WebTransaction\\/Servlet\\/default\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011134484,\"databaseDura" +
                        "tion\":null,\"duration\":0.54982126,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/cluster\\/list.do (GET)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\"" +
                        ":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011135075,\"databaseDuration\":null,\"duration\":0.011535307,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/Servlet\\/default\",\"type\":\"" +
                        "Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"304\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011135077,\"databaseDuration\":null,\"duration\":0.013844055,\"externalDuration\":null,\"queueDurati" +
                        "on\":null,\"name\":\"WebTransaction\\/Servlet\\/default\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"304\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011135077,\"databaseDuration\":null," +
                        "\"duration\":0.014596962,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/Servlet\\/default\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"304\"}],[{\"gcCumulative\":null,\"po" +
                        "rt\":8080,\"timestamp\":1411011135103,\"databaseDuration\":null,\"duration\":0.010493115,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/Servlet\\/default\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S" +
                        "\"},{},{\"httpResponseCode\":\"304\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011135106,\"databaseDuration\":null,\"duration\":0.011236177,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/S" +
                        "ervlet\\/default\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"304\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011135104,\"databaseDuration\":null,\"duration\":0.013607987,\"externalDu" +
                        "ration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/Servlet\\/default\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"304\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011138502" +
                        ",\"databaseDuration\":null,\"duration\":0.019654324,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/connection\\/consumerConnection.do (POST)\",\"type\":\"Transaction\",\"nr.apdexPerf" +
                        "Zone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011139900,\"databaseDuration\":null,\"duration\":0.008935865,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransa" +
                        "ction\\/SpringController\\/connection\\/producerConnection.do (POST)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011140476,\"databas" +
                        "eDuration\":null,\"duration\":0.23693725,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/topic\\/list.do (GET)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCo" +
                        "de\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011146586,\"databaseDuration\":null,\"duration\":0.010184211,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/topic" +
                        "\\/delete.do (POST)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011148974,\"databaseDuration\":null,\"duration\":0.006663283,\"externa" +
                        "lDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/topic\\/delete.do (POST)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":80" +
                        "80,\"timestamp\":1411011162353,\"databaseDuration\":null,\"duration\":0.011678532,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/namesrv\\/updateKvConfig.do (POST)\",\"type\":\"Trans" +
                        "action\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011164948,\"databaseDuration\":null,\"duration\":0.010754851,\"externalDuration\":null,\"queueDuration\":n" +
                        "ull,\"name\":\"WebTransaction\\/SpringController\\/message\\/queryMsgByOffset.do (POST)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":141101" +
                        "1166863,\"databaseDuration\":null,\"duration\":0.007540991,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/consumer\\/consumerProgress.do (POST)\",\"type\":\"Transaction\",\"nr.apdexP" +
                        "erfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011168007,\"databaseDuration\":null,\"duration\":0.008640795,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTra" +
                        "nsaction\\/SpringController\\/consumer\\/deleteSubGroup.do (POST)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011169118,\"databaseDu" +
                        "ration\":null,\"duration\":0.01824389,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringController\\/consumer\\/updateSubGroup.do (POST)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"htt" +
                        "pResponseCode\":\"200\"}],[{\"gcCumulative\":null,\"port\":8080,\"timestamp\":1411011170773,\"databaseDuration\":null,\"duration\":0.020410664,\"externalDuration\":null,\"queueDuration\":null,\"name\":\"WebTransaction\\/SpringContro" +
                        "ller\\/cluster\\/list.do (GET)\",\"type\":\"Transaction\",\"nr.apdexPerfZone\":\"S\"},{},{\"httpResponseCode\":\"200\"}]]]"
        );
    }
}
