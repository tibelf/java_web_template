package com.jd.jdda_collector.model;

import java.security.Timestamp;

/**
 * Created by tibelf on 9/15/14.
 */
public class MetricData implements Cloneable{
    private Long id;
    private String agentId;
    private Double timesliceStart;
    private Double timesliceEnd;
    private String name;
    private String scope;
    private Integer callCount;
    private Double totalCallTime;
    private Double totalExclusiveTime;
    private Double minCallTime;
    private Double maxCallTime;
    private Double sumOfsquares;

    public MetricData clone() throws CloneNotSupportedException {
        MetricData metricData = null;
        metricData = (MetricData) super.clone();
        return metricData;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Integer getCallCount() {
        return callCount;
    }

    public void setCallCount(Integer callCount) {
        this.callCount = callCount;
    }

    public Double getTotalCallTime() {
        return totalCallTime;
    }

    public void setTotalCallTime(Double totalCallTime) {
        this.totalCallTime = totalCallTime;
    }

    public Double getTotalExclusiveTime() {
        return totalExclusiveTime;
    }

    public void setTotalExclusiveTime(Double totalExclusiveTime) {
        this.totalExclusiveTime = totalExclusiveTime;
    }

    public Double getMinCallTime() {
        return minCallTime;
    }

    public void setMinCallTime(Double minCallTime) {
        this.minCallTime = minCallTime;
    }

    public Double getMaxCallTime() {
        return maxCallTime;
    }

    public void setMaxCallTime(Double maxCallTime) {
        this.maxCallTime = maxCallTime;
    }

    public Double getSumOfsquares() {
        return sumOfsquares;
    }

    public void setSumOfsquares(Double sumOfsquares) {
        this.sumOfsquares = sumOfsquares;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public Double getTimesliceStart() {
        return timesliceStart;
    }

    public void setTimesliceStart(Double timesliceStart) {
        this.timesliceStart = timesliceStart;
    }

    public Double getTimesliceEnd() {
        return timesliceEnd;
    }

    public void setTimesliceEnd(Double timesliceEnd) {
        this.timesliceEnd = timesliceEnd;
    }
}
