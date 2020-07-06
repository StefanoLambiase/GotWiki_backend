package com.unisa.gotwiki_backend.model.queryResult.episode;

import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class EpisodePerSeason {
    private String episodeTitle, episodeWriter;
    private Float viewerScore, imbdScore, tomatoScore;

    public String getEpisodeTitle() {
        return episodeTitle;
    }

    public void setEpisodeTitle(String episodeTitle) {
        this.episodeTitle = episodeTitle;
    }

    public String getEpisodeWriter() {
        return episodeWriter;
    }

    public void setEpisodeWriter(String episodeWriter) {
        this.episodeWriter = episodeWriter;
    }

    public Float getViewerScore() {
        return viewerScore;
    }

    public void setViewerScore(Float viewerScore) {
        this.viewerScore = viewerScore;
    }

    public Float getImbdScore() {
        return imbdScore;
    }

    public void setImbdScore(Float imbdScore) {
        this.imbdScore = imbdScore;
    }

    public Float getTomatoScore() {
        return tomatoScore;
    }

    public void setTomatoScore(Float tomatoScore) {
        this.tomatoScore = tomatoScore;
    }
}
