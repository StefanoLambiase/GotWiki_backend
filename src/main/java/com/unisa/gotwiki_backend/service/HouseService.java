package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.HouseEntity;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseKillCount;
import com.unisa.gotwiki_backend.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    HouseRepository houseRepository;

    /* search services */

    public Iterable<HouseEntity> findAll(){
        return houseRepository.findAll();
    }


    /* complex services */

    public String findWordsByHouseName(String houseName){
        return houseRepository.findWordsByHouseName(houseName);
    }

    public Iterable<HouseKillCount> findKillCountPerHouses(){
        return houseRepository.findKillCountPerHouses();
    }

}
