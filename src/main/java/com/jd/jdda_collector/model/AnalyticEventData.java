package com.jd.jdda_collector.model;

import java.security.Timestamp;

/**
 * Created by tibelf on 9/15/14.
 */
public class AnalyticEventData {
    private Long id;
    private String agentId;
    private Integer databaseCallCount;
    private Double databaseDuration;
    private Double duration;
    private String name;
    private String nrGuid;
    private String nrReferringTransactionGuid;
    private String nrTripId;
    private String nrPathHash;
    private String nrReferringPathHash;
    private String nrAlternatePathHashes;
    private String nrApdexPerfZone;
    private Double timestamp;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDatabaseCallCount() {
        return databaseCallCount;
    }

    public void setDatabaseCallCount(Integer databaseCallCount) {
        this.databaseCallCount = databaseCallCount;
    }

    public Double getDatabaseDuration() {
        return databaseDuration;
    }

    public void setDatabaseDuration(Double databaseDuration) {
        this.databaseDuration = databaseDuration;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNrGuid() {
        return nrGuid;
    }

    public void setNrGuid(String nrGuid) {
        this.nrGuid = nrGuid;
    }

    public String getNrReferringTransactionGuid() {
        return nrReferringTransactionGuid;
    }

    public void setNrReferringTransactionGuid(String nrReferringTransactionGuid) {
        this.nrReferringTransactionGuid = nrReferringTransactionGuid;
    }

    public String getNrTripId() {
        return nrTripId;
    }

    public void setNrTripId(String nrTripId) {
        this.nrTripId = nrTripId;
    }

    public String getNrPathHash() {
        return nrPathHash;
    }

    public void setNrPathHash(String nrPathHash) {
        this.nrPathHash = nrPathHash;
    }

    public String getNrReferringPathHash() {
        return nrReferringPathHash;
    }

    public void setNrReferringPathHash(String nrReferringPathHash) {
        this.nrReferringPathHash = nrReferringPathHash;
    }

    public String getNrAlternatePathHashes() {
        return nrAlternatePathHashes;
    }

    public void setNrAlternatePathHashes(String nrAlternatePathHashes) {
        this.nrAlternatePathHashes = nrAlternatePathHashes;
    }

    public String getNrApdexPerfZone() {
        return nrApdexPerfZone;
    }

    public void setNrApdexPerfZone(String nrApdexPerfZone) {
        this.nrApdexPerfZone = nrApdexPerfZone;
    }

    public Double getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Double timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }
}
