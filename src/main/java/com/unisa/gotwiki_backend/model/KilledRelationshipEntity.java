package com.unisa.gotwiki_backend.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type = "KILLED")
public class KilledRelationshipEntity {

    @Id private long id;

    private String location;
    private int importance;
    private int season;
    private String methodCat;
    private String method;
    private String allegiance;
    private String reason;
    private int episode;

    @StartNode private CharacterEntity characterKilled;
    @EndNode private CharacterEntity characterKiller;

    /* Getters & Setters */

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImportance() {
        return importance;
    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public String getMethodCat() {
        return methodCat;
    }

    public void setMethodCat(String methodCat) {
        this.methodCat = methodCat;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getAllegiance() {
        return allegiance;
    }

    public void setAllegiance(String allegiance) {
        this.allegiance = allegiance;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getEpisode() {
        return episode;
    }

    public void setEpisode(int episode) {
        this.episode = episode;
    }

    public CharacterEntity getCharacterKilled() {
        return characterKilled;
    }

    public void setCharacterKilled(CharacterEntity characterKilled) {
        this.characterKilled = characterKilled;
    }

    public CharacterEntity getCharacterKiller() {
        return characterKiller;
    }

    public void setCharacterKiller(CharacterEntity characterKiller) {
        this.characterKiller = characterKiller;
    }
}
