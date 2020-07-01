package com.unisa.gotwiki_backend.converter;

import org.neo4j.ogm.typeconversion.AttributeConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to convert two type of object (String and List<String>) in the node graph into a type List<String> in the Entity.
 * We use this class in CharacterEntity for the House attribute.
 */
public class CharacterHouseConverter implements AttributeConverter<List<String>, Object> {

    @Override
    public Object toGraphProperty(List<String> strings) {
        return null;
    }

    @Override
    public List<String> toEntityAttribute(Object o) {
        List<String> houses = new ArrayList<>();
        if(o instanceof String) {
            houses.add((String) o);
        } else {
            houses = (List<String>) o;
        }
        return houses;
    }
}
