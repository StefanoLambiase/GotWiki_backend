package com.unisa.gotwiki_backend.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity("House")
public class HouseEntity {

    @Id
    private Long id;

    private String religion;
    private String seat;
    private String words;
    private String lord;
    private String region;
    private String coa;
    private String name;
    private boolean alive;

    /* Getters & Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getLord() {
        return lord;
    }

    public void setLord(String lord) {
        this.lord = lord;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCoa() {
        return coa;
    }

    public void setCoa(String coa) {
        this.coa = coa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    /* Overrided methods */

    @Override
    public String toString() {
        return "HouseEntity{" +
                "id=" + id +
                ", religion='" + religion + '\'' +
                ", seat='" + seat + '\'' +
                ", words='" + words + '\'' +
                ", lord='" + lord + '\'' +
                ", region='" + region + '\'' +
                ", coa='" + coa + '\'' +
                ", name='" + name + '\'' +
                ", alive=" + alive +
                '}';
    }
}
