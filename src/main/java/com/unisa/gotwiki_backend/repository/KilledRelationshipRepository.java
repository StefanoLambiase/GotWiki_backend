package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.KilledRelationshipEntity;
import com.unisa.gotwiki_backend.model.queryResult.DeathCountPerCategory;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface KilledRelationshipRepository extends Neo4jRepository<KilledRelationshipEntity, Long> {

    @Query("MATCH (:Character)-[k:KILLED]->(c:Character)\n" +
            "  WHERE k.methodCat IS NOT NULL\n" +
            "RETURN k.methodCat AS methodCategory, count(k.methodCat) AS deathCount")
    Iterable<DeathCountPerCategory> findDeathCountPerKillCategory();

    @Query("MATCH (:Character)-[k:KILLED]->(c:Character)\n" +
            "WHERE k.methodCat IS NOT NULL\n" +
            "RETURN k.methodCat AS methodCategory, count(k.methodCat) AS deathCount, COLLECT(DISTINCT c.name) AS deadCharacterNames")
    Iterable<DeathCountPerCategory> findDeathCountAndKilledCharactersPerKillCategory();
}
