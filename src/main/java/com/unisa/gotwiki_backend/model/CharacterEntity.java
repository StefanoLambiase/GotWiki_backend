package com.unisa.gotwiki_backend.model;

import com.unisa.gotwiki_backend.converter.CharacterHouseConverter;
import com.unisa.gotwiki_backend.converter.CharacterIsAliveConverter;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.typeconversion.Convert;

import java.util.List;

@NodeEntity("Character")
public class CharacterEntity {

    @Id
    private Long id;

    private String name;
    private String actor;
    @Convert(CharacterHouseConverter.class)
    private List<String> house;
    private String imageFull;
    private String imageThumb;
    private String nickname;
    private Boolean isRoyal;
    @Convert(CharacterIsAliveConverter.class)
    private Boolean isAlive;

    @Relationship(type = "SIBLING_OF") private List<CharacterEntity> siblings;
    @Relationship(type = "SON_OF") private List<CharacterEntity> parents;
    @Relationship(type = "ENGAGED") private List<CharacterEntity> partners;
    @Relationship(type = "BELONGS_TO") private List<HouseEntity> belongingHouses;
    @Relationship(type = "APPEARS_IN") private List<SceneEntity> apparitionScenes;
    @Relationship(type = "KILLED") private KilledRelationshipEntity killedRelationshipEntity;

    /* Getters & Setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public List<String> getHouse() {
        return house;
    }

    public void setHouse(List<String> house) {
        this.house = house;
    }

    public String getImageFull() {
        return imageFull;
    }

    public void setImageFull(String imageFull) {
        this.imageFull = imageFull;
    }

    public String getImageThumb() {
        return imageThumb;
    }

    public void setImageThumb(String imageThumb) {
        this.imageThumb = imageThumb;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Boolean getRoyal() {
        return isRoyal;
    }

    public void setRoyal(Boolean royal) {
        isRoyal = royal;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public List<CharacterEntity> getSiblings() {
        return siblings;
    }

    public void setSiblings(List<CharacterEntity> siblings) {
        this.siblings = siblings;
    }

    public List<CharacterEntity> getParents() {
        return parents;
    }

    public void setParents(List<CharacterEntity> parents) {
        this.parents = parents;
    }

    public List<CharacterEntity> getPartners() {
        return partners;
    }

    public void setPartners(List<CharacterEntity> partners) {
        this.partners = partners;
    }

    public List<HouseEntity> getBelongingHouses() {
        return belongingHouses;
    }

    public void setBelongingHouses(List<HouseEntity> belongingHouses) {
        this.belongingHouses = belongingHouses;
    }

    public List<SceneEntity> getApparitionScenes() {
        return apparitionScenes;
    }

    public void setApparitionScenes(List<SceneEntity> apparitionScenes) {
        this.apparitionScenes = apparitionScenes;
    }

    public KilledRelationshipEntity getKilledRelationshipEntity() {
        return killedRelationshipEntity;
    }

    public void setKilledRelationshipEntity(KilledRelationshipEntity killedRelationshipEntity) {
        this.killedRelationshipEntity = killedRelationshipEntity;
    }

    /* Overrided methods */

    @Override
    public String toString() {
        return "CharacterEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actor='" + actor + '\'' +
                ", house=" + house +
                ", imageFull='" + imageFull + '\'' +
                ", imageThumb='" + imageThumb + '\'' +
                ", nickname='" + nickname + '\'' +
                ", isRoyal=" + isRoyal +
                ", isAlive=" + isAlive +
                ", siblings=" + siblings +
                ", parents=" + parents +
                ", partners=" + partners +
                ", belongingHouses=" + belongingHouses +
                ", apparitionScenes=" + apparitionScenes +
                ", killedRelationshipEntity=" + killedRelationshipEntity +
                '}';
    }
}
