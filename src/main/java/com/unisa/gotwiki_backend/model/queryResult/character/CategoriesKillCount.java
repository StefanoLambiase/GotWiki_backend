package com.unisa.gotwiki_backend.model.queryResult.character;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class CategoriesKillCount {

    private List<String> killMethodCategories;
    private List<Long> killCountPerCategories;

    /* Getter & Setters */
    public List<String> getKillMethodCategories() {
        return killMethodCategories;
    }

    public void setKillMethodCategories(List<String> killMethodCategories) {
        this.killMethodCategories = killMethodCategories;
    }

    public List<Long> getKillCountPerCategories() {
        return killCountPerCategories;
    }

    public void setKillCountPerCategories(List<Long> killCountPerCategories) {
        this.killCountPerCategories = killCountPerCategories;
    }
}
