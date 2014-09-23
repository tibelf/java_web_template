package com.jd.jdda_collector.service;

/**
 * Created by tibelf on 9/15/14.
 */
public interface CollectorService {
    public void parserAndSave(String data, String... args) throws Exception;
}
