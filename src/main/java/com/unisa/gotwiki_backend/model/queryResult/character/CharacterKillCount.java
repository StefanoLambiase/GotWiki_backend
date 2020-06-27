package com.unisa.gotwiki_backend.model.queryResult.character;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class CharacterKillCount {

    private CharacterEntity characterEntity;
    private List<String> killMethodCategories;
    private List<Long> killCountPerCategories;

    /* Getter & Setters */

    public CharacterEntity getCharacterEntity() {
        return characterEntity;
    }

    public void setCharacterEntity(CharacterEntity characterEntity) {
        this.characterEntity = characterEntity;
    }

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

    /* Overrided methods */

    @Override
    public String toString() {
        return "CharacterKillCount{" +
                "characterEntity=" + characterEntity.getName() +
                ", killMethods=" + killMethodCategories +
                ", killCount=" + killCountPerCategories +
                '}';
    }
}
