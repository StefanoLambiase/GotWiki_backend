package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.character.*;
import com.unisa.gotwiki_backend.model.queryResult.shared.SeasonDataCount;
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

    public Integer findCharacterKillCount(String name){
        return characterRepository.findCharacterKillCount(name);
    }

    /* Complex services */

    public Iterable<CharacterInLongestScene> findCharactersInLongestScenes(int maxNumberOfLongestScenes){
        return characterRepository.findCharactersInLongestScenes(maxNumberOfLongestScenes);
    }

    public CategoriesKillCount findKillCountPerCategoryPerCharacter(String characterName){
        return characterRepository.findKillCountPerCategoryPerCharacter(characterName);
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


    /* Queries used to create CharacterRelationships */

    public String[] findAllSiblingsPerCharacter(String characterName){
        return characterRepository.findAllSiblingsPerCharacter(characterName);
    }

    public String[] findAllParentsPerCharacter(String characterName){
        return characterRepository.findAllParentsPerCharacter(characterName);
    }

    public String[] findAllEngagedPerCharacter(String characterName){
        return characterRepository.findAllEngagedPerCharacter(characterName);
    }

    public KilledPerson[] findAllKilledPeoplePerCharacter(String characterName){
        return characterRepository.findAllKilledPeoplePerCharacter(characterName);
    }

    public SeasonDataCount findKillPerSeason(String characterName, int season){
        return characterRepository.findKillPerSeason(characterName, season);
    }

    public SeasonDataCount findScenePerSeason(String characterName, int season){
        return characterRepository.findScenePerSeason(characterName, season);
    }
}
