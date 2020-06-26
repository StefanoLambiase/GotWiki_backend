package com.unisa.gotwiki_backend.model.queryResult;

import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class DeathCountPerCategory {

    private String methodCategory;
    private int deathCount;
    private List<String> deadCharacterNames;

    /* Getters & Setters */

    public String getMethodCategory() {
        return methodCategory;
    }

    public void setMethodCategory(String methodCategory) {
        this.methodCategory = methodCategory;
    }

    public int getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(int deathCount) {
        this.deathCount = deathCount;
    }

    public List<String> getDeadCharacterNames() {
        return deadCharacterNames;
    }

    public void setDeadCharacterNames(List<String> deadCharacterNames) {
        this.deadCharacterNames = deadCharacterNames;
    }

    /* Overrided methods */

    @Override
    public String toString() {
        return "DeathCountPerCategory{" +
                "methodCategory='" + methodCategory + '\'' +
                ", deathCount=" + deathCount +
                ", deadCharacterNames=" + deadCharacterNames +
                '}';
    }
}
