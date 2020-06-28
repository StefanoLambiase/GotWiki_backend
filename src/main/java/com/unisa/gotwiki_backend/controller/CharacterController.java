package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterInLongestScene;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterKillCount;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterSceneCount;
import com.unisa.gotwiki_backend.model.queryResult.character.MurderAmongRelatives;
import com.unisa.gotwiki_backend.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    @Autowired
    CharacterService characterService;

    @GetMapping("/")
    Iterable<CharacterEntity> findAll(){
        return characterService.findAll();
    }


    @GetMapping("/by-name")
    CharacterEntity findByName(@RequestParam String name){
        CharacterEntity characterEntity = characterService.findByName(name);
        System.out.println("   " + characterEntity.toString());
        return characterEntity;
    }

    @GetMapping("/by-actor")
    public CharacterEntity findByActor(@RequestParam String actorName){
        return characterService.findByActor(actorName);
    }

    @GetMapping("/by-house")
    Iterable<CharacterEntity> findAllByHouse(@RequestParam String house){
        return characterService.findAllByHouse(house);
    }

    @GetMapping("/by-isRoyal")
    public Iterable<CharacterEntity> findAllByIsRoyal(@RequestParam Boolean isRoyal){
        return characterService.findAllByIsRoyal(isRoyal);
    }

    @GetMapping("/by-isAlive")
    public Iterable<CharacterEntity> findAllByIsAlive(@RequestParam Boolean isAlive){
        return characterService.findAllByIsAlive(isAlive);
    }

    @GetMapping("/with-nick")
    public Iterable<CharacterEntity> findAllWithNickname(){
        return characterService.findAllWithNickname();
    }

    @GetMapping("/without-nick")
    public Iterable<CharacterEntity> findAllWithoutNickname(){
        return characterService.findAllWithoutNickname();
    }

    @GetMapping("/with-one-house")
    public Iterable<CharacterEntity> findAllWithSingleHouse(){
        return characterService.findAllWithSingleHouse();
    }

    @GetMapping("/with-more-houses")
    public Iterable<CharacterEntity> findAllWithMoreHouse(){
        return characterService.findAllWithMoreHouse();
    }

    /* Complex Services */

    @GetMapping("/in-longest-scenes")
    public Iterable<CharacterInLongestScene> findCharactersInLongestScenes(@RequestParam int maxNumberOfLongestScenes){
        Iterable<CharacterInLongestScene> characterInLongestScenes = characterService.findCharactersInLongestScenes(maxNumberOfLongestScenes);
        for(CharacterInLongestScene characterInLongestScene : characterInLongestScenes){
            System.out.println(characterInLongestScene.toString());
        }
        return characterInLongestScenes;
    }

    @RequestMapping("/kill-count-per-category")
    public Iterable<CharacterKillCount> findAllKillCountPerCategoryPerCharacter(){
        Iterable<CharacterKillCount> characterKillCounts = characterService.findAllKillCountPerCategoryPerCharacter();
        for(CharacterKillCount characterKillCount : characterKillCounts){
            System.out.println(characterKillCount.toString());
        }
        return characterKillCounts;
    }

    @RequestMapping("/murder-among-relatives")
    public Iterable<MurderAmongRelatives> findAllMurdersAmongRelatives(){
        Iterable<MurderAmongRelatives> murderAmongRelatives = characterService.findAllMurdersAmongRelatives();
        for(MurderAmongRelatives murder : murderAmongRelatives){
            System.out.println(murder);
        }
        return murderAmongRelatives;
    }

    @RequestMapping("/suicides")
    public Iterable<CharacterEntity> findAllSuicideCharacter(){
        Iterable<CharacterEntity> characterEntities = characterService.findAllSuicideCharacter();
        for(CharacterEntity characterEntity : characterEntities){
            System.out.println(characterEntity.toString());
        }
        return characterEntities;
    }

    @GetMapping("/number-of-scenes")
    public Iterable<CharacterSceneCount> findNumberOfScenePerCharacter(){
        return characterService.findNumberOfScenePerCharacter();
    }
}
