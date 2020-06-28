package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.KilledRelationshipEntity;
import com.unisa.gotwiki_backend.model.queryResult.killed.DeathCountPerCategory;
import com.unisa.gotwiki_backend.model.queryResult.killed.DeathCountPerSeason;
import com.unisa.gotwiki_backend.model.queryResult.killed.KillPerImportance;
import com.unisa.gotwiki_backend.model.queryResult.killed.SeasonDeathPercentage;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface KilledRelationshipRepository extends Neo4jRepository<KilledRelationshipEntity, Long> {

    /* Search queries on main attributes */

    Iterable<KilledRelationshipEntity> findAll();

    Iterable<KilledRelationshipEntity> findAllByLocation(String location);

    Iterable<KilledRelationshipEntity> findAllBySeason(int season);

    Iterable<KilledRelationshipEntity> findAllByMethodCat(String methodCat);

    Iterable<KilledRelationshipEntity> findAllByEpisodeAndSeason(int episode, int season);

    Iterable<KilledRelationshipEntity> findAllByImportance(int importance);

    Iterable<KilledRelationshipEntity> findAllByAllegiance(String allegiance);

    @Query("MATCH (c1:Character{name:$name})-[kill:KILLED]->(c2:Character)\n" +
            "RETURN c1, kill, c2")
    Iterable<KilledRelationshipEntity> findAllByCharacterKillerName(String name);

    /* Complex queries */

    @Query("MATCH (c1)-[k:KILLED]->(c2)\n" +
            "WHERE k.importance < $maxImportanceNumber AND c1.name <> c2.name\n" +
            "\n" +
            "RETURN DISTINCT c1.name AS killerName, k.episode AS episode, k.season AS season, k.reason AS reason, count(k) AS numberOfKills, c2.name AS killedName")
    Iterable<KillPerImportance> findAllByMaxImportance(int maxImportanceNumber);

    @Query("MATCH (:Character)-[k:KILLED]->(c:Character)\n" +
            "WHERE k.methodCat IS NOT NULL\n" +
            "RETURN k.methodCat AS methodCategory, count(k.methodCat) AS deathCount")
    Iterable<DeathCountPerCategory> findDeathCountPerKillCategory();

    @Query("MATCH (:Character)-[k:KILLED]->(c:Character)\n" +
            "WHERE k.methodCat IS NOT NULL\n" +
            "RETURN k.methodCat AS methodCategory, count(k.methodCat) AS deathCount, COLLECT(DISTINCT c.name) AS deadCharacterNames")
    Iterable<DeathCountPerCategory> findDeathCountAndKilledCharactersPerKillCategory();

    @Query("MATCH ()-[k:KILLED]->()\n" +
            "WITH k.season AS season, count(k.season) AS killCount\n" +
            "ORDER BY season \n" +
            "RETURN season, killCount")
    Iterable<DeathCountPerSeason> findDeathCountPerSeason();

    @Query("MATCH ()-[k:KILLED]->()\n" +
            "WITH count(k) AS deathCount\n" +
            "\tMATCH ()-[k:KILLED]->()\n" +
            "\tWITH k.season AS season, count(k.season) AS deathSeason, deathCount\n" +
            " \tORDER BY season\n" +
            "    RETURN season, (toFloat(deathSeason)/deathCount) * 100 AS killPercentagePerSeason")
    Iterable<SeasonDeathPercentage> findSeasonDeathPercentage();
}
