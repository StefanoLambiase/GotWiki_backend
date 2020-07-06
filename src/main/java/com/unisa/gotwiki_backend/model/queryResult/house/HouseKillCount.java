package com.unisa.gotwiki_backend.model.queryResult.house;

import com.unisa.gotwiki_backend.model.entity.HouseEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class HouseKillCount {

    private String houseName, houseReligion, houseLord, houseCoa, houseSeat, houseWords, houseRegion;
    private int killCount;
    private boolean status;

    /* Getters & Setters */

    public String getHouseRegion() {
        return houseRegion;
    }

    public void setHouseRegion(String houseRegion) {
        this.houseRegion = houseRegion;
    }

    public String getHouseSeat() {
        return houseSeat;
    }

    public void setHouseSeat(String houseSeat) {
        this.houseSeat = houseSeat;
    }

    public String getHouseWords() {
        return houseWords;
    }

    public void setHouseWords(String houseWords) {
        this.houseWords = houseWords;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getHouseCoa() {
        return houseCoa;
    }

    public void setHouseCoa(String houseCoa) {
        this.houseCoa = houseCoa;
    }

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
