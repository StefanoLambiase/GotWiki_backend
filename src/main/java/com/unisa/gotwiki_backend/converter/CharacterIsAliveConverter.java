package com.unisa.gotwiki_backend.converter;

import org.neo4j.ogm.typeconversion.AttributeConverter;

public class CharacterIsAliveConverter implements AttributeConverter<Boolean, Object> {
    @Override
    public Object toGraphProperty(Boolean aBoolean) {
        return null;
    }

    @Override
    public Boolean toEntityAttribute(Object o) {
        Boolean isAlive;
        if(o instanceof String){
            isAlive = null;
        } else {
            isAlive = (Boolean) o;
        }
        return isAlive;
    }
}
