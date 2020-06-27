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

    public Iterable<SceneEntity> findAllByEpisode(Integer episode){
        return sceneRepository.findAllByEpisode(episode);
    }

    public Iterable<SceneEntity> findAllByLocation(String location){
        return sceneRepository.findAllByLocation(location);
    }

    public Iterable<SceneEntity> findAllBySublocation(String subLocation){
        return sceneRepository.findAllBySublocation(subLocation);
    }

    public Iterable<SceneEntity> findLongestScenes(Integer minimumTime){
        return sceneRepository.findLongestScenes(minimumTime);
    }

    public Iterable<SceneEntity> findCharacterAppearedInScenes(String character){
        return sceneRepository.findCharacterAppearedInScenes(character);
    }
}
