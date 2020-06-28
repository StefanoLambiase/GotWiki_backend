package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.LocationEntity;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationDeathCount;
import com.unisa.gotwiki_backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locations")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/by-name")
    public Iterable<LocationEntity> findAllByName(@RequestParam String name){
        return locationService.findAllByName(name);
    }

    @GetMapping("/")
    public Iterable<LocationEntity> findAll(){
        return locationService.findAll();
    }

    @GetMapping("/deathCount")
    public Iterable<LocationDeathCount> findDeathCountPerLocation(){
        return locationService.findDeathCountPerLocation();
    }
}
