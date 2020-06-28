package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.entity.EpisodeEntity;
import com.unisa.gotwiki_backend.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/episodes")
public class EpisodeController {

    @Autowired
    EpisodeService episodeService;

    @GetMapping("/")
    public Iterable<EpisodeEntity> findAll(){
        return episodeService.findAll();
    }

    @GetMapping("/by-season")
    public Iterable<EpisodeEntity> findAllBySeason(@RequestParam Integer season){
        return episodeService.findAllBySeason(season);
    }

    @GetMapping("/by-writer")
    public Iterable<EpisodeEntity> findAllByWriter(@RequestParam String writer){
        return episodeService.findAllByWriter(writer);
    }

    @GetMapping("/by-title")
    public Iterable<EpisodeEntity> findAllByTitle(@RequestParam String title){
        return episodeService.findAllByTitle(title);
    }

    @GetMapping("/by-date")
    public Iterable<EpisodeEntity> findAllByAirDate(@RequestParam String airDate){
        return episodeService.findAllByAirDate(airDate);
    }

    @GetMapping("/by-tomatoScore")
    public Iterable<EpisodeEntity> getByRottenTomatoes_Score(@RequestParam Float tomatoScore){
        return episodeService.getByRottenTomatoes_Score(tomatoScore);
    }

    @GetMapping("/by-greaterTomatoScore")
    public Iterable<EpisodeEntity> getAllGraterThanRottenTomatoes_Score(Float tomatoScore){
        return episodeService.getAllGraterThanRottenTomatoes_Score(tomatoScore);
    }

    @GetMapping("/by-greaterIMBD")
    public Iterable<EpisodeEntity> getAllGreaterThanIMBD_Score(Float scoreIMBD){
        return episodeService.getAllGreaterThanIMBD_Score(scoreIMBD);
    }

    @GetMapping("/by-year")
    public Iterable<EpisodeEntity> getAllEpisodePublishedInSpecifiedYear(String year){
        return episodeService.getAllEpisodePublishedInSpecifiedYear(year);
    }

    @GetMapping("/viewersScore")
    public Iterable<EpisodeEntity> getAllGreaterThanViewerScore(Float viewerScore){
        return episodeService.getAllGreaterThanViewerScore(viewerScore);
    }
}
