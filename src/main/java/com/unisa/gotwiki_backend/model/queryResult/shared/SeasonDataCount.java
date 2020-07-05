package com.unisa.gotwiki_backend.model.queryResult.shared;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class SeasonDataCount {
    private long season;
    private long count;

    public SeasonDataCount(long season, long count) {
        this.season = season;
        this.count = count;
    }

    public long getSeason() {
        return season;
    }

    public void setSeason(long season) {
        this.season = season;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
