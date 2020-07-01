package com.unisa.gotwiki_backend.controller;

import com.unisa.gotwiki_backend.model.entity.LocationEntity;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationAndSeasonDeathCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationAndSeasonSceneCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationDeathCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationMainInfo;
import com.unisa.gotwiki_backend.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/location-names")
    public Iterable<String> findAllLocationName(){
        return locationService.findAllLocationName();
    }

    /* Complex queries */

    @GetMapping("/deathCount")
    public Iterable<LocationDeathCount> findDeathCountPerLocation(){
        return locationService.findDeathCountPerLocation();
    }

    @GetMapping("/scene-count")
    public Iterable<LocationAndSeasonSceneCount> findSceneCountPerLocation(String locationName){
        return locationService.findSceneCountPerLocation(locationName);
    }

    @GetMapping("/death-count-season")
    public Iterable<LocationAndSeasonDeathCount> findDeathCountPerLocationAndSeason(@RequestParam String locationName, @RequestParam int season){
        return locationService.findDeathCountPerLocationAndSeason(locationName, season);
    }

    @GetMapping("/scene-count-season")
    public Iterable<LocationAndSeasonSceneCount> findSceneCountPerLocationAndSeason(@RequestParam String locationName, @RequestParam int season){
        return locationService.findSceneCountPerLocationAndSeason(locationName, season);
    }
}
