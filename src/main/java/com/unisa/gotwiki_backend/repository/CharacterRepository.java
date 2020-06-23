package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CharacterRepository extends Neo4jRepository<CharacterEntity, Long> {

    Iterable<CharacterEntity> findAllByHouse(String house);

    CharacterEntity findByName(String name);

    @Query("MATCH (n:Character)\n" +
            "WHERE n.name = 'Arya Stark'\n" +
            "RETURN n")
    CharacterEntity findArya();
}
