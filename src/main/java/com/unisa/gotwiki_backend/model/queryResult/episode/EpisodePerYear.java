package com.unisa.gotwiki_backend.model.queryResult.episode;

import com.unisa.gotwiki_backend.model.EpisodeEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class EpisodePerYear {
    private EpisodeEntity episodeEntity;
    private Integer episodeCount;

    public EpisodeEntity getEpisodeEntity() {
        return episodeEntity;
    }

    public void setEpisodeEntity(EpisodeEntity episodeEntity) {
        this.episodeEntity = episodeEntity;
    }

    public Integer getEpisodeCount() {
        return episodeCount;
    }

    public void setEpisodeCount(Integer episodeCount) {
        this.episodeCount = episodeCount;
    }
}
