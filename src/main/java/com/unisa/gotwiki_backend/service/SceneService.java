package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.SceneEntity;
import com.unisa.gotwiki_backend.repository.SceneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SceneService {
    @Autowired
    SceneRepository sceneRepository;

    public Iterable<SceneEntity> findAllBySeason(Integer season){
        return sceneRepository.findAllBySeason(season);
    }
}
