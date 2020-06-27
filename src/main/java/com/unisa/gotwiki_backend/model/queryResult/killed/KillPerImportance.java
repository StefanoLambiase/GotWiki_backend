package com.unisa.gotwiki_backend.model.queryResult.killed;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class KillPerImportance {

    private String killerName;
    private String killedName;

    private int episode;
    private int season;
    private int numberOfKills;
    private String reason;

    /* Getters & Setters */

    public String getKillerName() {
        return killerName;
    }

    public void setKillerName(String killerName) {
        this.killerName = killerName;
    }

    public String getKilledName() {
        return killedName;
    }

    public void setKilledName(String killedName) {
        this.killedName = killedName;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getNumberOfKills() {
        return numberOfKills;
    }

    public void setNumberOfKills(int numberOfKill) {
        this.numberOfKills = numberOfKill;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    /* Overrided methods */

    @Override
    public String toString() {
        return "KillPerImportance{" +
                "killerName='" + killerName + '\'' +
                ", killedName='" + killedName + '\'' +
                ", episode=" + episode +
                ", season=" + season +
                ", numberOfKills=" + numberOfKills +
                ", reason='" + reason + '\'' +
                '}';
    }

}
