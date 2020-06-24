package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.EpisodeEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EpisodeRepository extends Neo4jRepository<EpisodeEntity, Long> {

    Iterable<EpisodeEntity> findAllBySeason(Integer season);
}
