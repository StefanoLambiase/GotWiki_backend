package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.entity.EpisodeEntity;
import com.unisa.gotwiki_backend.model.queryResult.episode.EpisodePerSeason;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface EpisodeRepository extends Neo4jRepository<EpisodeEntity, Long> {

    /* SIMPLE QUERIES*/

    Iterable<EpisodeEntity> findAll();
    Iterable<EpisodeEntity> findAllBySeason(Integer season);
    Iterable<EpisodeEntity> findAllByWriter(String writer);
    Iterable<EpisodeEntity> findAllByTitle(String title);
    Iterable<EpisodeEntity> findAllByAirDate(String airDate);

    @Query("MATCH (e:Episode)\n" +
            "WHERE e.RottenTomatoes_Score = $tomatoScore\n" +
            "RETURN e")
    Iterable<EpisodeEntity> getByRottenTomatoes_Score(Float tomatoScore);

    @Query("MATCH (e:Episode)\n" +
            "WHERE e.RottenTomatoes_Score >= $tomatoScore\n" +
            "RETURN e")
    Iterable<EpisodeEntity> getAllGraterThanRottenTomatoes_Score(Float tomatoScore);

    @Query("MATCH (e:Episode)\n"+
           "WHERE e.IMBD_Score >= $scoreIMBD\n"+
            "RETURN e")
    Iterable<EpisodeEntity> getAllGreaterThanIMBD_Score(Float scoreIMBD);

    @Query("MATCH (e:Episode)\n" +
            "WITH e, count(*) AS epy\n" +
            "WHERE e.airDate CONTAINS $year\n"+
            "RETURN e AS episodeEntity, epy AS episodeCount")
    Iterable<EpisodeEntity> getAllEpisodePublishedInSpecifiedYear(String year);

    @Query("MATCH (e:Episode)\n" +
            "WHERE e.viewers >= $viewerScore\n" +
            "RETURN e")
    Iterable<EpisodeEntity> getAllGreaterThanViewerScore(Float viewerScore);

    @Query("MATCH (e:Episode)\n" +
            "WHERE e.season = $season\n" +
            "RETURN e.episode AS episodeNumber ,e.writer AS episodeWriter, e.title AS episodeTitle, e.IMBD_Score AS imbdScore, e.viewers AS viewerScore, e.RottenTomatoes_Score AS tomatoScore\n" +
            "ORDER BY e.episode")
    Iterable<EpisodePerSeason> getEpisodePerSeason(Integer season);
}
