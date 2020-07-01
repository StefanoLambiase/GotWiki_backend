package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.character.*;
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

    public CharacterEntity findByName(String name) {
        return characterRepository.findByName(name);
    }

    public CharacterEntity findByActor(String actorName){
        return characterRepository.findByActor(actorName);
    }

    public Iterable<CharacterEntity> findAllByHouse(String house){
        return characterRepository.findAllByHouse(house);
    }

    public Iterable<CharacterEntity> findAllByIsRoyal(Boolean isRoyal){
        return characterRepository.findAllByIsRoyal(isRoyal);
    }

    public Iterable<CharacterEntity> findAllByIsAlive(Boolean isAlive){
        return characterRepository.findAllByIsAlive(isAlive);
    }

    public Iterable<CharacterEntity> findAllWithNickname(){
        return characterRepository.findAllWithNickname();
    }

    public Iterable<CharacterEntity> findAllWithoutNickname(){
        return characterRepository.findAllWithoutNickname();
    }

    public Iterable<CharacterEntity> findAllWithSingleHouse(){
        return characterRepository.findAllWithSingleHouse();
    }

    public Iterable<CharacterEntity> findAllWithMoreHouse(){
        return characterRepository.findAllWithMoreHouse();
    }

    public Iterable<CharacterMainInfo> findAllCharacterMainInfo(){
        return characterRepository.findAllCharacterMainInfo();
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
