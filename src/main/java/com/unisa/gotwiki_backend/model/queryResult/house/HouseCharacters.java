package com.unisa.gotwiki_backend.model.queryResult.house;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import com.unisa.gotwiki_backend.model.HouseEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class HouseCharacters {

    private HouseEntity houseEntity;
    private List<CharacterEntity> characters;
    private int characterCount;

    /* Getters & Setters */

    public HouseEntity getHouseEntity() {
        return houseEntity;
    }

    public void setHouseEntity(HouseEntity houseEntity) {
        this.houseEntity = houseEntity;
    }

    public List<CharacterEntity> getCharacters() {
        return characters;
    }

    public void setCharacters(List<CharacterEntity> characters) {
        this.characters = characters;
    }

    public int getCharacterCount() {
        return characterCount;
    }

    public void setCharacterCount(int characterCount) {
        this.characterCount = characterCount;
    }
}
