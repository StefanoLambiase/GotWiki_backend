package com.unisa.gotwiki_backend.model;

import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.List;

@NodeEntity("Location")
public class LocationEntity {
    @Id
    private Long id;

    private String name;
    private List<String> sublocations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSublocations() {
        return sublocations;
    }

    public void setSublocations(List<String> sublocations) {
        this.sublocations = sublocations;
    }
}
