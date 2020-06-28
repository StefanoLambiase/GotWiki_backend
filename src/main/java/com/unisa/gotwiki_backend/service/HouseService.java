package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.HouseEntity;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseCharacters;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseKillCount;
import com.unisa.gotwiki_backend.repository.HouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    HouseRepository houseRepository;

    /* search services */

    public Iterable<HouseEntity> findAll(){
        return houseRepository.findAll();
    }

    public HouseEntity findBy(Long id){
        return houseRepository.findBy(id);
    }

    public HouseEntity findByName(String name){
        return houseRepository.findByName(name);
    }

    public Iterable<HouseEntity> findAllByReligion(String religion){
        return houseRepository.findAllByReligion(religion);
    }

    public HouseEntity findByWords(String words){
        return houseRepository.findByWords(words);
    }

    public Iterable<HouseEntity> findBySeat(String seat){
        return houseRepository.findBySeat(seat);
    }

    public HouseEntity findByLord(String lord){
        return houseRepository.findByLord(lord);
    }

    public Iterable<HouseEntity> findAllByAlive(boolean alive){
        return houseRepository.findAllByAlive(alive);
    }

    /* complex services */

    public String findWordsByHouseName(String houseName){
        return houseRepository.findWordsByHouseName(houseName);
    }

    public Iterable<HouseKillCount> findKillCountPerHouses(){
        return houseRepository.findKillCountPerHouses();
    }

    public Iterable<HouseKillCount> findDeathCountPerHouses(){
        return houseRepository.findDeathCountPerHouses();
    }

    public Iterable<HouseCharacters> findAllCharactersByAlive(Boolean alive){
        return houseRepository.findAllCharactersByAlive(alive);
    }

    /* queries to find common attributes values */

    public Iterable<String> findAllReligion(){
        return houseRepository.findAllReligion();
    }

    public Iterable<String> findAllRegion(){
        return houseRepository.findAllRegion();
    }

    public Iterable<String> findAllSeat(){
        return houseRepository.findAllSeat();
    }

    public Iterable<String> findAllName(){
        return houseRepository.findAllName();
    }

}
