package com.petty.app.model;

import androidx.room.Entity;

import androidx.room.PrimaryKey;

@Entity(tableName = "behavior_logs")

public class BehaviorLog {

    @PrimaryKey(autoGenerate = true)

    private long id;

    private String petName;

    private String behavior;

    private String subReason;

    private String recommendation;

    private long timestamp;

    public BehaviorLog(String petName, String behavior, long timestamp) {

        this.petName = petName;

        this.behavior = behavior;

        this.timestamp = timestamp;

    }

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPetName() { return petName; }

    public void setPetName(String petName) { this.petName = petName; }

    public String getBehavior() { return behavior; }

    public void setBehavior(String behavior) { this.behavior = behavior; }

    public String getSubReason() { return subReason; }

    public void setSubReason(String subReason) { this.subReason = subReason; }

    public String getRecommendation() { return recommendation; }

    public void setRecommendation(String recommendation) { this.recommendation = recommendation; }

    public long getTimestamp() { return timestamp; }

    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }

}
