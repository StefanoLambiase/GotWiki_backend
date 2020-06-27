package com.unisa.gotwiki_backend.repository;

import com.unisa.gotwiki_backend.model.HouseEntity;
import com.unisa.gotwiki_backend.model.queryResult.house.HouseKillCount;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface HouseRepository extends Neo4jRepository<HouseEntity, Long> {

    /* search queries on main attributes */

    HouseEntity findBy(Long id);

    HouseEntity findByName(String name);

    Iterable<HouseEntity> findAllByReligion(String religion);

    HouseEntity findByWords(String words);

    HouseEntity findByLord(String lord);

    Iterable<HouseEntity> findAllByAlive(boolean alive);

    /* complex queries */

    @Query("MATCH (c:House{name : $houseName})\n" +
            "RETURN c.words")
    String findWordsByHouseName(String houseName);

    @Query("MATCH (h:House), (c:Character{house : h.name}), ((c)-[k:KILLED]->())\n" +
            "WITH h AS houseEntity, count(k) AS killCount\n" +
            "RETURN houseEntity, killCount\n" +
            "ORDER BY killCount DESC")
    Iterable<HouseKillCount> findKillCountPerHouses();

}
