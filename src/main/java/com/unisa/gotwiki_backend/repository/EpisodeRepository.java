package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.EpisodeEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EpisodeRepository extends Neo4jRepository<EpisodeEntity, Long> {

    /* SIMPLE QUERIES*/

    Iterable<EpisodeEntity> findAll();
    Iterable<EpisodeEntity> findAllBySeason(Integer season);
    Iterable<EpisodeEntity> findAllByWriter(String writer);
    Iterable<EpisodeEntity> findAllByTitle(String title);
    Iterable<EpisodeEntity> findAllByAirDate(String airDate);
}
