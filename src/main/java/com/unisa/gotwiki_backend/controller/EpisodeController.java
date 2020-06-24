package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.EpisodeEntity;
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

    @GetMapping("/by-season")
    public Iterable<EpisodeEntity> findAllBySeason(@RequestParam Integer season){
        return episodeService.findAllBySeason(season);
    }
}
