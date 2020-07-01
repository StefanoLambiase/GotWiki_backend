package com.unisa.gotwiki_backend.model.queryResult.character;

import com.unisa.gotwiki_backend.converter.CharacterHouseConverter;
import com.unisa.gotwiki_backend.converter.CharacterIsAliveConverter;
import com.unisa.gotwiki_backend.converter.CharacterMainInfoHouseConverter;
import org.neo4j.ogm.annotation.typeconversion.Convert;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class CharacterMainInfo {

    private String name;
    @Convert(CharacterMainInfoHouseConverter.class)
    private String[] house;
    private Boolean isRoyal;
    @Convert(CharacterIsAliveConverter.class)
    private Boolean isAlive;
    private String imageFull;
    private String nickname;
    private String actor;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHouse() {
        return house;
    }

    public void setHouse(String[] house) {
        this.house = house;
    }

    public Boolean getRoyal() {
        return isRoyal;
    }

    public void setRoyal(Boolean royal) {
        isRoyal = royal;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public String getImageFull() {
        return imageFull;
    }

    public void setImageFull(String imageFull) {
        this.imageFull = imageFull;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }
}
