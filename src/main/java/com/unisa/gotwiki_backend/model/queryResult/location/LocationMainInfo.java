package com.unisa.gotwiki_backend.model.queryResult.location;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class LocationMainInfo {
    String locationName;
    String[] subLocationNames;
    int deathCount;
    int sceneCount;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String[] getSubLocationNames() {
        return subLocationNames;
    }

    public void setSubLocationNames(String[] subLocationNames) {
        this.subLocationNames = subLocationNames;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getSceneCount() {
        return sceneCount;
    }

    public void setSceneCount(int sceneCount) {
        this.sceneCount = sceneCount;
    }
}
