package com.unisa.gotwiki_backend.model.queryResult.killed;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class SeasonDeathPercentage {
    private Integer season;
    private Float killPercentagePerSeason;

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Float getKillPercentagePerSeason() {
        return killPercentagePerSeason;
    }

    public void setKillPercentagePerSeason(Float killPercentagePerSeason) {
        this.killPercentagePerSeason = killPercentagePerSeason;
    }
}
