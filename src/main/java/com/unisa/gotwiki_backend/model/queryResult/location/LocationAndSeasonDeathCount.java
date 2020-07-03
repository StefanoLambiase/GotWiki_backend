package com.unisa.gotwiki_backend.model.queryResult.location;

import com.unisa.gotwiki_backend.model.entity.LocationEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class LocationAndSeasonDeathCount {
    private int season;
    private int count;

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
