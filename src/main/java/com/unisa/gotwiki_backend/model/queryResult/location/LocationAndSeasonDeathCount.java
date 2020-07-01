package com.unisa.gotwiki_backend.model.queryResult.location;

import com.unisa.gotwiki_backend.model.entity.LocationEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class LocationAndSeasonDeathCount {
    private String locationName;
    private int deathCount;
    private int season;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }
}
