package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.CharacterEntity;
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

    @GetMapping("/by-house")
    Iterable<CharacterEntity> getAllByHouses(@RequestParam String house){
        return characterService.findAllByHouse(house);
    }

    @GetMapping("/by-name")
    CharacterEntity findByName(@RequestParam String name){
        return characterService.findByName(name);
    }

    @GetMapping("/Arya")
    CharacterEntity findArya(){
        return characterService.findArya();
    }
}
