package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.HouseEntity;
import com.unisa.gotwiki_backend.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    HouseRepository houseRepository;

    public Iterable<HouseEntity> findAll(){
        return houseRepository.findAll();
    }
}
