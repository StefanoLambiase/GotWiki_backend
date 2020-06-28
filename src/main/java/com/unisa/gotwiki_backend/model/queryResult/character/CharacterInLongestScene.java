package com.unisa.gotwiki_backend.model.queryResult.character;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class CharacterInLongestScene {
    private CharacterEntity characterEntity;
    private Double sceneTimeInMinutes;

    /* Getters & Setters */

    public CharacterEntity getCharacterEntity() {
        return characterEntity;
    }

    public void setCharacterEntity(CharacterEntity characterEntity) {
        this.characterEntity = characterEntity;
    }

    public Double getSceneTimeInMinutes() {
        return sceneTimeInMinutes;
    }

    public void setSceneTimeInMinutes(Double sceneTimeInMinutes) {
        this.sceneTimeInMinutes = sceneTimeInMinutes;
    }

    /* Overrided methods */

    @Override
    public String toString() {
        return "CharacterInLongestScene{" +
                "characterEntity=" + characterEntity + "\n" +
                "    - sceneTimeInMinutes=" + sceneTimeInMinutes +
                '}';
    }
}
