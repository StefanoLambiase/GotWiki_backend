package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.CharacterInLongestScene;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CharacterRepository extends Neo4jRepository<CharacterEntity, Long> {

    /* Search queries on main attributes */

    Iterable<CharacterEntity> findAll();

    CharacterEntity findByName(String name);

    CharacterEntity findByActor(String actorName);

    Iterable<CharacterEntity> findAllByHouse(String house);

    Iterable<CharacterEntity> findAllByIsRoyal(Boolean isRoyal);

    Iterable<CharacterEntity> findAllByIsAlive(Boolean isAlive);

    @Query("MATCH (n:Character)\n" +
            "WHERE (n.nickname <> \"None\")\n" +
            "RETURN n")
    Iterable<CharacterEntity> findAllWithNickname();

    @Query("MATCH (n:Character)\n" +
            "WHERE (n.nickname = \"None\")\n" +
            "RETURN n")
    Iterable<CharacterEntity> findAllWithoutNickname();

    @Query("MATCH (n:Character)\n" +
            "WHERE apoc.meta.type(n.house) <> \"String[]\"\n" +
            "RETURN n;")
    Iterable<CharacterEntity> findAllWithSingleHouse();

    @Query("MATCH (n:Character)\n" +
            "WHERE apoc.meta.type(n.house) = \"String[]\"\n" +
            "RETURN n;")
    Iterable<CharacterEntity> findAllWithMoreHouse();

    /* Complex queries */

    @Query("MATCH (s:Scene)\n" +
            "WITH toFloat(duration.inSeconds(s.start, s.end).seconds) / 60.0 AS minutes, s\n" +
            "ORDER BY minutes DESC\n" +
            "LIMIT $maxNumberOfLongestScenes\n" +
            "  \n" +
            "MATCH (c:Character)-[:APPEARS_IN]->(s)\n" +
            "RETURN DISTINCT c AS characterEntity, minutes AS sceneTimeInMinutes")
    Iterable<CharacterInLongestScene> findCharactersInLongestScenes(int maxNumberOfLongestScenes);



}
