package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.entity.LocationEntity;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationAndSeasonDeathCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationAndSeasonSceneCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationDeathCount;
import com.unisa.gotwiki_backend.model.queryResult.location.LocationMainInfo;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface LocationRepository extends Neo4jRepository<LocationEntity, Long> {

    Iterable<LocationEntity> findAllByName(String name);
    Iterable<LocationEntity> findAll();

    @Query("MATCH (l:Location)\n" +
            "RETURN DISTINCT l.name")
    Iterable<String> findAllLocationName();

    @Query("MATCH (s:Scene)-[:SET_IN]->(l:Location)\n" +
            "WITH l.name AS locationName, l.sublocations AS subLocationNames, count(s) AS sceneCount\n" +
            "MATCH ()-[k:KILLED]->()\n" +
            "WHERE k.location = locationName OR (k.location IN subLocationNames)\n" +
            "RETURN locationName, subLocationNames, sceneCount, count(k) AS deathCount")
    Iterable<LocationMainInfo> findAllLocationMainInfo();

    /* Complex queries */

    @Query("MATCH (l:Location), ()-[k:KILLED]->()\n" +
            "WHERE l.name = k.location OR (k.location IN l.sublocations)\n" +
            "RETURN l AS locationEntity, count(k) AS deathCount")
    Iterable<LocationDeathCount> findDeathCountPerLocation();

    @Query("MATCH (s:Scene)-[:SET_IN]->(l:Location)\n" +
            "WHERE l.name=$locationName\n" +
            "RETURN count(s) AS count")
    Iterable<LocationAndSeasonSceneCount> findSceneCountPerLocation(String locationName);

    @Query("MATCH (l:Location), ()-[k:KILLED]->()\n" +
            "WHERE l.name=$locationName AND (l.name=k.location OR (k.location IN l.sublocations)) AND k.season=$season\n" +
            "RETURN count(k) AS count, k.season AS season\n")
    LocationAndSeasonDeathCount findDeathCountPerLocationAndSeason(String locationName, int season);

    @Query("MATCH (s:Scene)-[:SET_IN]->(l:Location)\n" +
            "WHERE l.name=$locationName AND s.season=$season\n" +
            "RETURN count(s) AS count, s.season AS season\n")
    LocationAndSeasonSceneCount findSceneCountPerLocationAndSeason(String locationName, int season);
}
