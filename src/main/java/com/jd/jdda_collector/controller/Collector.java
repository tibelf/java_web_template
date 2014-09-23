package com.jd.jdda_collector.controller;

import com.jd.jdda_collector.service.AnalyticEventCollectorServiceImpl;
import com.jd.jdda_collector.service.ConnectCollectorServiceImpl;
import com.jd.jdda_collector.service.MetricCollectorServiceImpl;
import com.jd.jdda_collector.service.SqlTraceCollectorServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@Controller
@RequestMapping("/agent_listener")
public class Collector {
    @Resource
    private MetricCollectorServiceImpl metricCollectorService;
    @Resource
    private SqlTraceCollectorServiceImpl sqlTraceCollectorService;
    @Resource
    private AnalyticEventCollectorServiceImpl analyticEventCollectorService;
    @Resource
    private ConnectCollectorServiceImpl connectCollectorService;

    private static Logger logger = LoggerFactory.getLogger(Collector.class);

    @RequestMapping(value = "/{version}/{key}/connect", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public String connect(@PathVariable String version, @PathVariable String key,
                                @RequestParam(value = "marshal_format") String format,
                                @RequestBody String body) throws Exception {
        logger.debug("version is {}, key is {}", version, key);
        logger.debug("body is {}", body);
        connectCollectorService.parserAndSave(body);
//        return "{\"return_value\":{\"agent_run_id\":1156475178}}";
        return String.format("{\"return_value\":{\"agent_run_id\":%d}}", connectCollectorService.getAgetId());
    }

    @RequestMapping(value = "/{version}/{key}/metric_data", method = RequestMethod.POST)
    @ResponseBody
    public String metricData(@PathVariable String version, @PathVariable String key, @RequestParam(value = "run_id") String agentId,
                                   @RequestParam(value = "marshal_format") String format, @RequestBody String body) throws Exception {

        logger.debug("version is {}, key is {}", version, key);
        logger.debug("body is {}", body);
        try{
            metricCollectorService.parserAndSave(body);
        } catch (Exception e) {
            logger.error("Exception : ", e);
            throw e;
        }
        return "{\"return_value\":[]}";
    }

    @RequestMapping(value = "/{version}/{key}/sql_trace_data", method = RequestMethod.POST)
    @ResponseBody
    public String sqlTraceData(@PathVariable String version, @PathVariable String key, @RequestParam(value = "run_id") String agentId,
                                   @RequestParam(value = "marshal_format") String format, @RequestBody String body) throws Exception {
        logger.debug("version is {}, key is {}", version, key);
        logger.debug("body is {}", body);
        try{
            sqlTraceCollectorService.parserAndSave(body, agentId);
        }catch (Exception e) {
            logger.error("Exception : ", e);
            throw e;
        }
        return "{\"return_value\":[]}";
    }

    @RequestMapping(value = "/{version}/{key}/analytic_event_data", method = RequestMethod.POST)
    @ResponseBody
    public String analyticEventData(@PathVariable String version, @PathVariable String key, @RequestParam(value = "run_id") String agentId,
                                   @RequestParam(value = "marshal_format") String format, @RequestBody String body) throws Exception {
        logger.debug("version is {}, key is {}", version, key);
        logger.debug("body is {}", body);
        try {
            analyticEventCollectorService.parserAndSave(body);
        } catch (Exception e) {
            logger.error("Exception : ", e);
            throw e;
        }
        return "{\"return_value\":[]}";
    }

    @RequestMapping(value = "/{version}/{key}/get_agent_commands", method = RequestMethod.POST)
    @ResponseBody
    public String getAgentCommands(@PathVariable String version, @PathVariable String key, @RequestParam(value = "run_id") String agentId,
                                          @RequestParam(value = "marshal_format") String format, @RequestBody String body) {
        logger.debug("version is {}, key is {}", version, key);
        logger.debug("body is {}", body);
        return "{\"return_value\":[]}";
    }

    @RequestMapping(value = "/{version}/{key}/test", method = RequestMethod.GET)
    @ResponseBody
    public String test(@PathVariable String version, @PathVariable String key, @RequestParam(value = "run_id") String agentId,
                                         @RequestParam(value = "marshal_format") String format, @RequestBody String body) {
        logger.debug("version is {}, key is {}", version, key);
        logger.debug("body is {}", body);
        return "{\"return_value\":[]}";
    }

    @RequestMapping(value = "/{version}/{key}/*", method = RequestMethod.GET)
    @ResponseBody
    public String any(@PathVariable String version, @PathVariable String key, @RequestBody String body) {
        logger.debug("body is {}", body);
        return "{\"return_value\":[ddd]}";
    }

}