package com.unisa.gotwiki_backend.model.queryResult.location;

import com.unisa.gotwiki_backend.model.entity.LocationEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class LocationDeathCount {
    private LocationEntity locationEntity;
    private Integer deathCount;

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public Integer getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(Integer deathCount) {
        this.deathCount = deathCount;
    }

}
