package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CharacterRepository extends Neo4jRepository<CharacterEntity, Long> {

    @Query("MATCH (n:Character)\n" +
            "WHERE apoc.meta.type(n.house) = \"String[]\"\n" +
            "RETURN n;")
    Iterable<CharacterEntity> findAllWithMoreHouse();

    @Query("MATCH (n:Character)\n" +
            "WHERE apoc.meta.type(n.house) <> \"String[]\"\n" +
            "RETURN n;")
    Iterable<CharacterEntity> findAllWithSingleHouse();

    Iterable<CharacterEntity> findAllByHouse(String house);

    CharacterEntity findByName(String name);

}
