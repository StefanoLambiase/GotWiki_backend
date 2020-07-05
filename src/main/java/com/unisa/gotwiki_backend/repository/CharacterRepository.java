package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.character.*;
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

    @Query("MATCH (c:Character)-[a:APPEARS_IN]->()\n" +
            "RETURN c.name AS name, c.house AS house, c.isRoyal AS isRoyal, c.isAlive AS isAlive, c.nickname AS nickname, c.actor AS actor, c.imageFull AS imageFull, count(a) AS sceneCount")
    Iterable<CharacterMainInfo> findAllCharacterMainInfo();

    @Query("MATCH (c:Character)-[k:KILLED]->()\n" +
            "WHERE c.name = $name\n" +
            "RETURN count(k)")
    Integer findCharacterKillCount(String name);

    /* Complex queries */

    @Query("MATCH (s:Scene)\n" +
            "WITH toFloat(duration.inSeconds(s.start, s.end).seconds) / 60.0 AS minutes, s\n" +
            "ORDER BY minutes DESC\n" +
            "LIMIT $maxNumberOfLongestScenes\n" +
            "  \n" +
            "MATCH (c:Character)-[:APPEARS_IN]->(s)\n" +
            "RETURN DISTINCT c AS characterEntity, minutes AS sceneTimeInMinutes")
    Iterable<CharacterInLongestScene> findCharactersInLongestScenes(int maxNumberOfLongestScenes);

    @Query("MATCH (c:Character)-[k:KILLED]->(:Character)\n" +
            "WHERE c.name = $characterName\n" +
            "WITH c, k.methodCat AS mc, count(k.methodCat) AS mcCount\n" +
            "   ORDER BY mcCount DESC\n" +
            "RETURN collect(mc) AS killMethodCategories, collect(mcCount) AS killCountPerCategories")
    CategoriesKillCount findKillCountPerCategoryPerCharacter(String characterName);

    @Query("MATCH (killer:Character)-[murder:KILLED]->(killed:Character)\n" +
            "\n" +
            "MATCH path = (killer)-->(killed)\n" +
            "WHERE ANY (r IN relationships(path)\n" +
            "    WHERE\n" +
            "        type(r) = 'SON_OF' OR\n" +
            "        type(r) = 'SIBLING_OF' OR\n" +
            "        type(r) = 'ENGAGED'\n" +
            ")\n" +
            "\n" +
            "RETURN killer, murder, killed, path")
    Iterable<MurderAmongRelatives> findAllMurdersAmongRelatives();

    @Query("MATCH (c1:Character)-[suicide:KILLED]->(c2:Character)\n" +
            "WHERE ID(c1) = ID(c2)\n" +
            "\n" +
            "WITH c1, count(suicide) AS nSuicide\n" +
            "WHERE nSuicide = 1\n" +
            "\n" +
            "RETURN c1")
    Iterable<CharacterEntity> findAllSuicideCharacter();

    @Query("MATCH (s:Scene), (c:Character)-[a:APPEARS_IN]->()\n" +
            "RETURN c, count(a)")
    Iterable<CharacterSceneCount> findNumberOfScenePerCharacter();

    /* Queries used to create CharacterRelationships */

    @Query("MATCH (c1:Character)-[s:SIBLING_OF]->(c2)\n" +
            "WHERE c1.name = $characterName\n" +
            "RETURN c2.name")
    String[] findAllSiblingsPerCharacter(String characterName);

    @Query("MATCH (c1:Character)-[s:SON_OF]->(c2)\n" +
            "WHERE c1.name = $characterName\n" +
            "RETURN c2.name")
    String[] findAllParentsPerCharacter(String characterName);

    @Query("MATCH (c1:Character)-[s:ENGAGED]->(c2)\n" +
            "WHERE c1.name = $characterName\n" +
            "RETURN c2.name")
    String[] findAllEngagedPerCharacter(String characterName);

    @Query("MATCH (c1:Character)-[k:KILLED]->(c2)\n" +
            "WHERE c1.name = $characterName\n" +
            "RETURN c2.name AS name, count(c2) AS count")
    KilledPerson[] findAllKilledPeoplePerCharacter(String characterName);
}
