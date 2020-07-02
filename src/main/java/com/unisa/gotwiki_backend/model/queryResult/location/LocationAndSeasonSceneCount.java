package com.unisa.gotwiki_backend.model.queryResult.location;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class LocationAndSeasonSceneCount {
    private int season;
    private int sceneCount;

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getSceneCount() {
        return sceneCount;
    }

    public void setSceneCount(int sceneCount) {
        this.sceneCount = sceneCount;
    }
}
