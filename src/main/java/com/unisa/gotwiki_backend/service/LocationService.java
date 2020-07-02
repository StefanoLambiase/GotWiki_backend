package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.entity.LocationEntity;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationAndSeasonDeathCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationAndSeasonSceneCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationDeathCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationMainInfo;
import com.unisa.gotwiki_backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public Iterable<LocationEntity> findAllByName(String name){
        return locationRepository.findAllByName(name);
    }

    public Iterable<LocationEntity> findAll(){
        return locationRepository.findAll();
    }

    public Iterable<String> findAllLocationName(){
        return locationRepository.findAllLocationName();
    }

    public Iterable<LocationMainInfo> findAllLocationMainInfo(){
        return locationRepository.findAllLocationMainInfo();
    }

    /* Complex queries */

    public Iterable<LocationDeathCount> findDeathCountPerLocation(){
        return locationRepository.findDeathCountPerLocation();
    }

    public Iterable<LocationAndSeasonSceneCount> findSceneCountPerLocation(String locationName){
        return locationRepository.findSceneCountPerLocation(locationName);
    }

    public LocationAndSeasonDeathCount findDeathCountPerLocationAndSeason(String locationName, int season){
        return locationRepository.findDeathCountPerLocationAndSeason(locationName, season);
    }

    public LocationAndSeasonSceneCount findSceneCountPerLocationAndSeason(String locationName, int season){
        return locationRepository.findSceneCountPerLocationAndSeason(locationName, season);
    }

}
