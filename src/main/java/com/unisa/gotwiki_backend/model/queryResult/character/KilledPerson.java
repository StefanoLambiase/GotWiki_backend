package com.unisa.gotwiki_backend.model.queryResult.character;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class KilledPerson {
    private String name;
    private long count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }
}
