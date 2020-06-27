package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.HouseEntity;
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

    /* complex services */

    @RequestMapping("/word-by-house")
    public String findWordsByHouseName(@RequestParam String houseName){
        return houseService.findWordsByHouseName(houseName);
    }

    @RequestMapping("/find-kill-count")
    public Iterable<HouseKillCount> findKillCountPerHouses(){
        return houseService.findKillCountPerHouses();
    }

}
