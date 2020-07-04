package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.entity.HouseEntity;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseCharacters;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseKillCount;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HouseRepository extends Neo4jRepository<HouseEntity, Long> {

    /* search queries on main attributes */

    HouseEntity findBy(Long id);

    HouseEntity findByName(String name);

    Iterable<HouseEntity> findAllByReligion(String religion);

    HouseEntity findByWords(String words);

    Iterable<HouseEntity> findBySeat(String seat);

    HouseEntity findByLord(String lord);

    Iterable<HouseEntity> findAllByAlive(boolean alive);

    /* complex queries */

    @Query("MATCH (c:House{name : $houseName})\n" +
            "RETURN c.words")
    String findWordsByHouseName(String houseName);

    @Query("MATCH (h:House), (c:Character{house : h.name}), ((c)-[k:KILLED]->())\n" +
            "WITH h AS houseEntity, count(k) AS killCount\n" +
            "RETURN houseEntity.alive AS status, houseEntity.words AS houseWords,houseEntity.seat AS houseSeat,houseEntity.name AS houseName, houseEntity.religion AS houseReligion, houseEntity.lord AS houseLord, houseEntity.coa AS houseCoa, killCount\n" +
            "ORDER BY killCount DESC")
    Iterable<HouseKillCount> findKillCountPerHouses();

    @Query("MATCH (h:House), (c:Character{house:h.name}), (()-[k:KILLED]->(c))\n" +
            "WITH h AS houseEntity, count(k) AS deathCount\n" +
            "RETURN houseEntity.alive AS status, houseEntity.words AS houseWords,houseEntity.seat AS houseSeat,houseEntity.name AS houseName, houseEntity.religion AS houseReligion, houseEntity.lord AS houseLord, houseEntity.coa AS houseCoa, deathCount\n" +
            "ORDER BY deathCount DESC")
    Iterable<HouseKillCount> findDeathCountPerHouses();

    @Query("MATCH (h:House), (c:Character)\n" +
            "WHERE (c.isAlive = $alive) AND h.name IN c.house\n" +
            "RETURN h AS houseEntity, count(c) AS aliveCount, collect(c.name) AS characters")
    Iterable<HouseCharacters> findAllCharactersByAlive(Boolean alive);

    /* queries to find common attributes values */

    @Query("MATCH (h:House)\n" +
            "RETURN DISTINCT h.religion")
    Iterable<String> findAllReligion();

    @Query("MATCH (h:House)\n" +
            "RETURN DISTINCT h.region")
    Iterable<String> findAllRegion();

    @Query("MATCH (h:House)\n" +
            "RETURN DISTINCT h.seat")
    Iterable<String> findAllSeat();

    @Query("MATCH (h:House)\n" +
            "RETURN DISTINCT h.name")
    Iterable<String> findAllName();

}
