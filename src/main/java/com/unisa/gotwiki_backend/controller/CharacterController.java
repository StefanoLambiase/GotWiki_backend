package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.CharacterInLongestScene;
import com.unisa.gotwiki_backend.model.queryResult.CharacterKillCount;
import com.unisa.gotwiki_backend.model.queryResult.MurderAmongRelatives;
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

    @GetMapping("/test")
    void findAllTest(){
        for(CharacterEntity characterEntity : characterService.findAll()){
            System.out.println(characterEntity.getName());
            if(characterEntity.getHouse().size() > 1){
                System.out.println("   " + characterEntity.getHouse().toString());
            }
        }
    }

    @GetMapping("/by-house")
    Iterable<CharacterEntity> findAllByHouse(@RequestParam String house){
        return characterService.findAllByHouse(house);
    }

    @GetMapping("/by-name")
    CharacterEntity findByName(@RequestParam String name){
        CharacterEntity characterEntity = characterService.findByName(name);
        System.out.println("   " + characterEntity.toString());
        return characterEntity;
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

}
