package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.EpisodeEntity;
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
}
