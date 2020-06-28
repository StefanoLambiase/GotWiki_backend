package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterInLongestScene;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterKillCount;
import com.unisa.gotwiki_backend.model.queryResult.character.CharacterSceneCount;
import com.unisa.gotwiki_backend.model.queryResult.character.MurderAmongRelatives;
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

    @Query("MATCH (c:Character)-[k:KILLED]->(:Character)\n" +
            "WITH c, k.methodCat AS mc, count(k.methodCat) AS mcCount\n" +
            "   ORDER BY mcCount DESC\n" +
            "RETURN c AS CharacterEntity, collect(mc) AS killMethodCategories, collect(mcCount) AS killCountPerCategories")
    Iterable<CharacterKillCount> findAllKillCountPerCategoryPerCharacter();

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
}
