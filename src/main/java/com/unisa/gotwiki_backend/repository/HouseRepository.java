package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.HouseEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HouseRepository extends Neo4jRepository<HouseEntity, Long> {

}
