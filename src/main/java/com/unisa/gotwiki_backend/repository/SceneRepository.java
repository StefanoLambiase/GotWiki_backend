package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.SceneEntity;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SceneRepository extends Neo4jRepository<SceneEntity, Long> {

    Iterable<SceneEntity> findAllBySeason(Integer season);
    Iterable<SceneEntity> findAllByEpisode(Integer episode);
    Iterable<SceneEntity> findAllByLocation(String location);
    Iterable<SceneEntity> findAllBySublocation(String subLocation);

    @Query("MATCH (s:Scene)\n" +
            "WITH toFloat(duration.inSeconds(s.start, s.end).seconds) / 60.0 AS minutes, s\n" +
            "ORDER BY minutes DESC\n" +
            "WHERE minutes >= $minimumTime\n" +
            "RETURN s"
    )
    Iterable<SceneEntity> findLongestScenes(Integer minimumTime);

    @Query("MATCH (s:Scene)\n" +
            "WHERE $character IN s.characters\n"+
            "RETURN s"
    )
    Iterable<SceneEntity> findCharacterAppearedInScenes(String character);


}
