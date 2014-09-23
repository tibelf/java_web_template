package com.jd.jdda_collector.model;

/**
 * Created by tibelf on 9/15/14.
 */
public class SqlTraceData {
    private Long id;
    private String agentId;
    private String path;
    private String url;
    private String sqlId;
    private String sql;
    private String databaseMetricName;
    private Integer callCount;
    private Integer totalCallTime;
    private Integer minCallTime;
    private Integer maxCallTime;
    private String backTrace;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSqlId() {
        return sqlId;
    }

    public void setSqlId(String sqlId) {
        this.sqlId = sqlId;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public Integer getTotalCallTime() {
        return totalCallTime;
    }

    public void setTotalCallTime(Integer totalCallTime) {
        this.totalCallTime = totalCallTime;
    }

    public Integer getMinCallTime() {
        return minCallTime;
    }

    public void setMinCallTime(Integer minCallTime) {
        this.minCallTime = minCallTime;
    }

    public Integer getMaxCallTime() {
        return maxCallTime;
    }

    public void setMaxCallTime(Integer maxCallTime) {
        this.maxCallTime = maxCallTime;
    }

    public String getBackTrace() {
        return backTrace;
    }

    public void setBackTrace(String backTrace) {
        this.backTrace = backTrace;
    }

    public String getDatabaseMetricName() {
        return databaseMetricName;
    }

    public void setDatabaseMetricName(String databaseMetricName) {
        this.databaseMetricName = databaseMetricName;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
//    private String explainPlan;

}
