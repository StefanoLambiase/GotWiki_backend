package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.HouseEntity;
import com.unisa.gotwiki_backend.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("/")
    Iterable<HouseEntity> findAll(){
        return houseService.findAll();
    }
}
