package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CharacterRepository extends Neo4jRepository<CharacterEntity, Long> {

    /* Search queries on main attributes */

    Iterable<CharacterEntity> findAllByHouse(String house);

    Iterable<CharacterEntity> findAllByIsRoyal(Boolean isRoyal);

    CharacterEntity findByName(String name);

    CharacterEntity findByActor(String actorName);

    @Query("MATCH (n:Character)\n" +
            "WHERE apoc.meta.type(n.house) = \"String[]\"\n" +
            "RETURN n;")
    Iterable<CharacterEntity> findAllWithMoreHouse();

    @Query("MATCH (n:Character)\n" +
            "WHERE apoc.meta.type(n.house) <> \"String[]\"\n" +
            "RETURN n;")
    Iterable<CharacterEntity> findAllWithSingleHouse();


}
