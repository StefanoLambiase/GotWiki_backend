package com.unisa.gotwiki_backend.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


@NodeEntity("Episode")
public class EpisodeEntity {
    @Id
    private Long id;

    //attributes
    private Float IMBD_Score;
    private String writer;
    private String title;
    private String airDate;
    private Integer season;
    private Float viewers;
    private Integer episodeGlobal;
    private Integer episode;
    private Float rottenTomatoes_Score;

    /* Getters & Setters*/

    public Float getIMBD_Score() {
        return IMBD_Score;
    }

    public void setIMBD_Score(Float IMBD_Score) {
        this.IMBD_Score = IMBD_Score;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Integer getSeason() {
        return season;
    }

    public void setSeason(Integer season) {
        this.season = season;
    }

    public Float getViewers() {
        return viewers;
    }

    public void setViewers(Float viewers) {
        this.viewers = viewers;
    }

    public Integer getEpisodeGlobal() {
        return episodeGlobal;
    }

    public void setEpisodeGlobal(Integer episodeGlobal) {
        this.episodeGlobal = episodeGlobal;
    }

    public Integer getEpisode() {
        return episode;
    }

    public void setEpisode(Integer episode) {
        this.episode = episode;
    }

    public Float getRottenTomatoes_Score() {
        return rottenTomatoes_Score;
    }

    public void setRottenTomatoes_Score(Float rottenTomatoes_Score) {
        this.rottenTomatoes_Score = rottenTomatoes_Score;
    }
}
