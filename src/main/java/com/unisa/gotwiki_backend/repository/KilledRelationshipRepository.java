package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.KilledRelationshipEntity;
import com.unisa.gotwiki_backend.model.queryResult.DeathCountPerCategory;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface KilledRelationshipRepository extends Neo4jRepository<KilledRelationshipEntity, Long> {

    Iterable<KilledRelationshipEntity> findAll();

    @Query("MATCH (c1:Character{name:$name})-[kill:KILLED]->(c2:Character)\n" +
            "RETURN c1, kill, c2")
    Iterable<KilledRelationshipEntity> findAllByCharacterKillerName(String name);

    @Query("MATCH (:Character)-[k:KILLED]->(c:Character)\n" +
            "WHERE k.methodCat IS NOT NULL\n" +
            "RETURN k.methodCat AS methodCategory, count(k.methodCat) AS deathCount")
    Iterable<DeathCountPerCategory> findDeathCountPerKillCategory();

    @Query("MATCH (:Character)-[k:KILLED]->(c:Character)\n" +
            "WHERE k.methodCat IS NOT NULL\n" +
            "RETURN k.methodCat AS methodCategory, count(k.methodCat) AS deathCount, COLLECT(DISTINCT c.name) AS deadCharacterNames")
    Iterable<DeathCountPerCategory> findDeathCountAndKilledCharactersPerKillCategory();
}
