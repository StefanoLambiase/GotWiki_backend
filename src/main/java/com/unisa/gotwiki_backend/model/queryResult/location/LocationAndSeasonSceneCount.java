package com.unisa.gotwiki_backend.model.queryResult.location;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class LocationAndSeasonSceneCount {
    private String locationName;
    private int sceneCount;
    private int season;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getSceneCount() {
        return sceneCount;
    }

    public void setSceneCount(int sceneCount) {
        this.sceneCount = sceneCount;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
