package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.SceneEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SceneRepository extends Neo4jRepository<SceneEntity, Long> {

    Iterable<SceneEntity> findAllBySeason(Integer season);
}
