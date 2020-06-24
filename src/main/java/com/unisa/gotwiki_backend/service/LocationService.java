package com.unisa.gotwiki_backend.service;

import com.unisa.gotwiki_backend.model.LocationEntity;
import com.unisa.gotwiki_backend.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public Iterable<LocationEntity> findAllByName(String name){
        return locationRepository.findAllByName(name);
    }
}
