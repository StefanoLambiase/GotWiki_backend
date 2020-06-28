package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.LocationEntity;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationDeathCount;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LocationRepository extends Neo4jRepository<LocationEntity, Long> {

    Iterable<LocationEntity> findAllByName(String name);
    Iterable<LocationEntity> findAll();

    @Query("MATCH (l:Location), ()-[k:KILLED]->()\n" +
            "WHERE l.name = k.location\n" +
            "RETURN l AS locationEntity, count(k) AS deathCount")
    Iterable<LocationDeathCount> findDeathCountPerLocation();
}
