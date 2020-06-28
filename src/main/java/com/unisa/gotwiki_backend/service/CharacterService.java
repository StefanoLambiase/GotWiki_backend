package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterInLongestScene;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterKillCount;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterSceneCount;
import com.unisa.gotwiki_backend.model.queryResult.character.MurderAmongRelatives;
import com.unisa.gotwiki_backend.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    /* Search services */

    public Iterable<CharacterEntity> findAll(){
        return characterRepository.findAll();
    }

    public Iterable<CharacterEntity> findAllByHouse(String house){
        return characterRepository.findAllByHouse(house);
    }

    public CharacterEntity findByName(String name) {
        return characterRepository.findByName(name);
    }


    /* Complex services */

    public Iterable<CharacterInLongestScene> findCharactersInLongestScenes(int maxNumberOfLongestScenes){
        return characterRepository.findCharactersInLongestScenes(maxNumberOfLongestScenes);
    }

    public Iterable<CharacterKillCount> findAllKillCountPerCategoryPerCharacter(){
        return characterRepository.findAllKillCountPerCategoryPerCharacter();
    }

    public Iterable<MurderAmongRelatives> findAllMurdersAmongRelatives(){
        return characterRepository.findAllMurdersAmongRelatives();
    }

    public Iterable<CharacterEntity> findAllSuicideCharacter(){
        return characterRepository.findAllSuicideCharacter();
    }

    public Iterable<CharacterSceneCount> findNumberOfScenePerCharacter(){
        return characterRepository.findNumberOfScenePerCharacter();
    }
}
