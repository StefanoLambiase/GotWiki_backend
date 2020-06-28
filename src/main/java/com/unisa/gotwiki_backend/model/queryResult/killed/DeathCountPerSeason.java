package com.unisa.gotwiki_backend.model.queryResult.killed;

public class DeathCountPerSeason {
    private Integer season, killCount;

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Integer getKillCount() {
        return killCount;
    }

    public void setKillCount(Integer killCount) {
        this.killCount = killCount;
    }
}
