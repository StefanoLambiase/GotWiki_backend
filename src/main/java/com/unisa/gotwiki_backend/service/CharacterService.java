package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import com.unisa.gotwiki_backend.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterService {

    @Autowired
    CharacterRepository characterRepository;

    public CharacterEntity findArya() {
        return characterRepository.findArya();
    }

    public Iterable<CharacterEntity> findAllByHouse(String house){
        return characterRepository.findAllByHouse(house);
    }

    public CharacterEntity findByName(String name) {
        return characterRepository.findByName(name);
    }
}
