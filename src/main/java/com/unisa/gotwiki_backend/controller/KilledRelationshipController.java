package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.KilledRelationshipEntity;
import com.unisa.gotwiki_backend.model.queryResult.DeathCountPerCategory;
import com.unisa.gotwiki_backend.service.KilledRelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kills")
public class KilledRelationshipController {

    @Autowired
    KilledRelationshipService killedRelationshipService;

    @RequestMapping("/")
    public Iterable<KilledRelationshipEntity> findAll(){
        return killedRelationshipService.findAll();
    }

    @RequestMapping("/by-killer-name")
    public Iterable<KilledRelationshipEntity> findAllByCharacterKillerName(@RequestParam String name){
        return killedRelationshipService.findAllByCharacterKillerName(name);
    }

    @RequestMapping("/death-count-kill-category")
    public Iterable<DeathCountPerCategory> findDeathCountPerKillCategory(){
        Iterable<DeathCountPerCategory> deathCountPerCategories = killedRelationshipService.findDeathCountPerKillCategory();
        for(DeathCountPerCategory deathCountPerCategory : deathCountPerCategories){
            System.out.println(deathCountPerCategory.toString());
        }
        return deathCountPerCategories;
    }

    @RequestMapping("/dc-and-cn-kill-category")
    public Iterable<DeathCountPerCategory> findDeathCountAndKilledCharactersPerKillCategory(){
        Iterable<DeathCountPerCategory> deathCountPerCategories = killedRelationshipService.findDeathCountAndKilledCharactersPerKillCategory();
        for(DeathCountPerCategory deathCountPerCategory : deathCountPerCategories){
            System.out.println(deathCountPerCategory.toString());
        }
        return deathCountPerCategories;
    }
}
