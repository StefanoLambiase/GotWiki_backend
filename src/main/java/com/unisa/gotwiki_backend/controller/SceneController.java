package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.SceneEntity;
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
}
