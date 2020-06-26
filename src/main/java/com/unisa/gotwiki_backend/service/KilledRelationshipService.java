package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.KilledRelationshipEntity;
import com.unisa.gotwiki_backend.model.queryResult.DeathCountPerCategory;
import com.unisa.gotwiki_backend.repository.KilledRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KilledRelationshipService {

    @Autowired
    KilledRelationshipRepository killedRelationshipRepository;

    public Iterable<KilledRelationshipEntity> findAll() {
        return killedRelationshipRepository.findAll();
    }

    public Iterable<KilledRelationshipEntity> findAllByCharacterKillerName(String name){
        return killedRelationshipRepository.findAllByCharacterKillerName(name);
    }

    public Iterable<DeathCountPerCategory> findDeathCountPerKillCategory(){
        return killedRelationshipRepository.findDeathCountPerKillCategory();
    }

    public Iterable<DeathCountPerCategory> findDeathCountAndKilledCharactersPerKillCategory(){
        return killedRelationshipRepository.findDeathCountAndKilledCharactersPerKillCategory();
    }
}
