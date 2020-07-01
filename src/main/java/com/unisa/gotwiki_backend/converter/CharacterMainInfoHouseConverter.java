package com.unisa.gotwiki_backend.converter;

import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.util.ArrayList;
import java.util.List;

public class CharacterMainInfoHouseConverter implements AttributeConverter<String[], Object>{

    @Override
    public Object toGraphProperty(String[] strings) {
        return null;
    }

    @Override
    public String[] toEntityAttribute(Object o) {
        String[] houses = new String[1];
        if(o instanceof String) {
            houses[0] = (String) o;
        } else {
            houses = (String[]) o;
        }
        return houses;
    }
}
