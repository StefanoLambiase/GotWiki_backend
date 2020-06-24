package com.unisa.gotwiki_backend.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.Relationship;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@NodeEntity("Scene")
public class SceneEntity {
    @Id
    private Long id;

    //attributes
    private String location;
    private Integer season;
    private List<String> characters;
    private Integer episode;
    private String sublocation;
    private LocalTime end;
    private LocalTime start;

    @Property("id")
    private Integer identifier;     //da cambiare nel db

    @Relationship(type = "si svolge in")
    private EpisodeEntity episodeEntity;

    /*
    DA INSERIRE APPENA SI IMPLEMENTA LOCATION
    @Relationship(type = "avviene nella")
    private LocationEntity locationEntity;*/

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public List<String> getCharacters() {
        return characters;
    }

    public void setCharacters(List<String> characters) {
        this.characters = characters;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public String getSublocation() {
        return sublocation;
    }

    public void setSublocation(String sublocation) {
        this.sublocation = sublocation;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }
}
