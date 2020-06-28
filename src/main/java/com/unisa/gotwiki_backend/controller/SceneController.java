package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.entity.SceneEntity;
import com.unisa.gotwiki_backend.model.queryResult.scene.DeathCountPerScene;
import com.unisa.gotwiki_backend.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/scenes")
public class SceneController {

    @Autowired
    SceneService sceneService;

    @GetMapping("/by-season")
    public Iterable<SceneEntity> findAllBySeason(@RequestParam Integer season){
        return sceneService.findAllBySeason(season);
    }

    @GetMapping("/by-episode")
    public Iterable<SceneEntity> findAllByEpisode(Integer episode){
        return sceneService.findAllByEpisode(episode);
    }

    @GetMapping("/by-location")
    public Iterable<SceneEntity> findAllByLocation(String location){
        return sceneService.findAllByLocation(location);
    }

    @GetMapping("/by-sublocation")
    public Iterable<SceneEntity> findAllBySublocation(String subLocation){
        return sceneService.findAllBySublocation(subLocation);
    }

    @GetMapping("/longestScenes")
    public Iterable<SceneEntity> findLongestScenes(Integer minimumTime){
        return sceneService.findLongestScenes(minimumTime);
    }

    @GetMapping("/by-character")
    public Iterable<SceneEntity> findCharacterAppearedInScenes(String character){
        return sceneService.findCharacterAppearedInScenes(character);
    }

    @GetMapping("/death-scenes")
    public Iterable<DeathCountPerScene> findDeathCountPerScene(){
        return sceneService.findDeathCountPerScene();
    }
}
