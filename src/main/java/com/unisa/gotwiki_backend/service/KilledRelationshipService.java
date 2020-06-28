package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.KilledRelationshipEntity;
import com.unisa.gotwiki_backend.model.queryResult.killed.DeathCountPerCategory;
import com.unisa.gotwiki_backend.model.queryResult.killed.DeathCountPerSeason;
import com.unisa.gotwiki_backend.model.queryResult.killed.KillPerImportance;
import com.unisa.gotwiki_backend.model.queryResult.killed.SeasonDeathPercentage;
import com.unisa.gotwiki_backend.repository.KilledRelationshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KilledRelationshipService {

    @Autowired
    KilledRelationshipRepository killedRelationshipRepository;

    /* Search services on main attyributes */

    public Iterable<KilledRelationshipEntity> findAll() {
        return killedRelationshipRepository.findAll();
    }

    public Iterable<KilledRelationshipEntity> findAllByCharacterKillerName(String name){
        return killedRelationshipRepository.findAllByCharacterKillerName(name);
    }

    /* Complex services */

    public Iterable<KillPerImportance> findAllByMaxImportance(int maxImportanceNumber){
        return killedRelationshipRepository.findAllByMaxImportance(maxImportanceNumber);
    }

    public Iterable<DeathCountPerCategory> findDeathCountPerKillCategory(){
        return killedRelationshipRepository.findDeathCountPerKillCategory();
    }

    public Iterable<DeathCountPerCategory> findDeathCountAndKilledCharactersPerKillCategory(){
        return killedRelationshipRepository.findDeathCountAndKilledCharactersPerKillCategory();
    }

    public Iterable<DeathCountPerSeason> findDeathCountPerSeason(){
        return killedRelationshipRepository.findDeathCountPerSeason();
    }

    public Iterable<SeasonDeathPercentage> findSeasonDeathPercentage(){
        return killedRelationshipRepository.findSeasonDeathPercentage();
    }
}
