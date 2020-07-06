package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.entity.EpisodeEntity;
import com.unisa.gotwiki_backend.model.queryResult.episode.EpisodePerSeason;
import com.unisa.gotwiki_backend.repository.EpisodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {

    @Autowired
    EpisodeRepository episodeRepository;

    public Iterable<EpisodeEntity> findAll(){
        return episodeRepository.findAll();
    }

    public Iterable<EpisodeEntity> findAllBySeason(Integer season){
        return episodeRepository.findAllBySeason(season);
    }

    public Iterable<EpisodeEntity> findAllByWriter(String writer){
        return episodeRepository.findAllByWriter(writer);
    }

    public Iterable<EpisodeEntity> findAllByTitle(String title){
        return episodeRepository.findAllByTitle(title);
    }

    public Iterable<EpisodeEntity> findAllByAirDate(String airDate){
        return episodeRepository.findAllByAirDate(airDate);
    }

    public Iterable<EpisodeEntity> getByRottenTomatoes_Score(Float tomatoScore){
        return episodeRepository.getByRottenTomatoes_Score(tomatoScore);
    }

    public Iterable<EpisodeEntity> getAllGraterThanRottenTomatoes_Score(Float tomatoScore){
        return episodeRepository.getAllGraterThanRottenTomatoes_Score(tomatoScore);
    }

    public Iterable<EpisodeEntity> getAllGreaterThanIMBD_Score(Float scoreIMBD){
        return episodeRepository.getAllGreaterThanIMBD_Score(scoreIMBD);
    }

    public Iterable<EpisodeEntity> getAllEpisodePublishedInSpecifiedYear(String year){
        return episodeRepository.getAllEpisodePublishedInSpecifiedYear(year);
    }

    public Iterable<EpisodeEntity> getAllGreaterThanViewerScore(Float viewerScore){
        return episodeRepository.getAllGreaterThanViewerScore(viewerScore);
    }

    public Iterable<EpisodePerSeason> getEpisodePerSeason(Integer season){
        return episodeRepository.getEpisodePerSeason(season);
    }
}
