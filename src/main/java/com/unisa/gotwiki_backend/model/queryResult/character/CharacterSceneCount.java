package com.unisa.gotwiki_backend.model.queryResult.character;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;

public class CharacterSceneCount {
    private CharacterEntity characterEntity;
    private Integer sceneCount;

    public CharacterEntity getCharacterEntity() {
        return characterEntity;
    }

    public void setCharacterEntity(CharacterEntity characterEntity) {
        this.characterEntity = characterEntity;
    }

    public Integer getSceneCount() {
        return sceneCount;
    }

    public void setSceneCount(Integer sceneCount) {
        this.sceneCount = sceneCount;
    }
}
