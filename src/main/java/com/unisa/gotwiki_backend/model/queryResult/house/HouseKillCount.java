package com.unisa.gotwiki_backend.model.queryResult.house;

import com.unisa.gotwiki_backend.model.entity.HouseEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class HouseKillCount {

    private String houseName, houseReligion, houseLord;
    private int killCount;

    /* Getters & Setters */

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getHouseReligion() {
        return houseReligion;
    }

    public void setHouseReligion(String houseReligion) {
        this.houseReligion = houseReligion;
    }

    public String getHouseLord() {
        return houseLord;
    }

    public void setHouseLord(String houseLord) {
        this.houseLord = houseLord;
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
                "houseName=" + houseName +
                "houseLord=" + houseLord +
                "houseReligion=" + houseReligion +
                ", killCount=" + killCount +
                '}';
    }
}
