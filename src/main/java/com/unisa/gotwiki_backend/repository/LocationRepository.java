package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.LocationEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LocationRepository extends Neo4jRepository<LocationEntity, Long> {

    Iterable<LocationEntity> findAllByName(String name);

}
