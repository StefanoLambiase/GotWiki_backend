package com.unisa.gotwiki_backend.model.queryResult.character;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class CharacterRelationships {
    private String[] siblings;
    private String[] parents;
    private String[] engaged;

    public String[] getSiblings() {
        return siblings;
    }

    public void setSiblings(String[] siblings) {
        this.siblings = siblings;
    }

    public String[] getParents() {
        return parents;
    }

    public void setParents(String[] parents) {
        this.parents = parents;
    }

    public String[] getEngaged() {
        return engaged;
    }

    public void setEngaged(String[] engaged) {
        this.engaged = engaged;
    }
}
