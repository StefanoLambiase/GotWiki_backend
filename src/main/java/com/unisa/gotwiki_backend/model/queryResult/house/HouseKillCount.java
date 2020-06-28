package com.unisa.gotwiki_backend.model.queryResult.house;

import com.unisa.gotwiki_backend.model.entity.HouseEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class HouseKillCount {

    private HouseEntity houseEntity;
    private int killCount;

    /* Getters & Setters */

    public HouseEntity getHouseEntity() {
        return houseEntity;
    }

    public void setHouseEntity(HouseEntity houseEntity) {
        this.houseEntity = houseEntity;
    }

    public int getKillCount() {
        return killCount;
    }

    public void setKillCount(int killCount) {
        this.killCount = killCount;
    }

    /* Overrided methods */

    @Override
    public String toString() {
        return "HouseKillCount{" +
                "houseEntity=" + houseEntity +
                ", killCount=" + killCount +
                '}';
    }
}
