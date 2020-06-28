package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.entity.HouseEntity;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseCharacters;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseKillCount;
import com.unisa.gotwiki_backend.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/houses")
public class HouseController {

    @Autowired
    HouseService houseService;

    /* search services */

    @GetMapping("/")
    Iterable<HouseEntity> findAll(){
        return houseService.findAll();
    }

    @RequestMapping("/by-id")
    public HouseEntity findBy(@RequestParam Long id){
        return houseService.findBy(id);
    }

    @RequestMapping("/by-name")
    public HouseEntity findByName(@RequestParam String name){
        return houseService.findByName(name);
    }

    @RequestMapping("/by-religion")
    public Iterable<HouseEntity> findAllByReligion(@RequestParam String religion){
        return houseService.findAllByReligion(religion);
    }

    @RequestMapping("/by-words")
    public HouseEntity findByWords(@RequestParam String words){
        return houseService.findByWords(words);
    }

    @RequestMapping("/by-seat")
    public Iterable<HouseEntity> findBySeat(@RequestParam String seat){
        return houseService.findBySeat(seat);
    }

    @RequestMapping("/by-lord")
    public HouseEntity findByLord(@RequestParam String lord){
        return houseService.findByLord(lord);
    }

    @RequestMapping("/by-alive")
    public Iterable<HouseEntity> findAllByAlive(@RequestParam boolean alive){
        return houseService.findAllByAlive(alive);
    }

    /* complex services */

    @RequestMapping("/word-by-house")
    public String findWordsByHouseName(@RequestParam String houseName){
        return houseService.findWordsByHouseName(houseName);
    }

    @RequestMapping("/find-kill-count")
    public Iterable<HouseKillCount> findKillCountPerHouses(){
        return houseService.findKillCountPerHouses();
    }

    @RequestMapping("/find-death-count")
    public Iterable<HouseKillCount> findDeathCountPerHouses(){
        return houseService.findDeathCountPerHouses();
    }

    @RequestMapping("/characters-by-alive")
    public Iterable<HouseCharacters> findAllCharactersByAlive(@RequestParam Boolean alive){
        return houseService.findAllCharactersByAlive(alive);
    }

    /* queries to find common attributes values */

    @GetMapping("/all-religion")
    public Iterable<String> findAllReligion(){
        return houseService.findAllReligion();
    }

    @GetMapping("/all-region")
    public Iterable<String> findAllRegion(){
        return houseService.findAllRegion();
    }

    @GetMapping("/all-seat")
    public Iterable<String> findAllSeat(){
        return houseService.findAllSeat();
    }

    @GetMapping("/all-name")
    public Iterable<String> findAllName(){
        return houseService.findAllName();
    }

}
