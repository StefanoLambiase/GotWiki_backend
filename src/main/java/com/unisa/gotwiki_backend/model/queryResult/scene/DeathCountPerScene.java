package com.unisa.gotwiki_backend.model.queryResult.scene;

import com.unisa.gotwiki_backend.model.entity.CharacterEntity;
import com.unisa.gotwiki_backend.model.entity.KilledRelationshipEntity;
import com.unisa.gotwiki_backend.model.entity.SceneEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

import java.util.List;

@QueryResult
public class DeathCountPerScene {
    private SceneEntity sceneEntity;
    private Integer deathCount;
    private List<KilledRelationshipEntity> killsInfo;
    private List<CharacterEntity> charsInfo;

    public SceneEntity getSceneEntity() {
        return sceneEntity;
    }

    public void setSceneEntity(SceneEntity sceneEntity) {
        this.sceneEntity = sceneEntity;
    }

    public Integer getDeathCount() {
        return deathCount;
    }

    public void setDeathCount(Integer deathCount) {
        this.deathCount = deathCount;
    }

    public List<KilledRelationshipEntity> getKillsInfo() {
        return killsInfo;
    }

    public void setKillsInfo(List<KilledRelationshipEntity> killsInfo) {
        this.killsInfo = killsInfo;
    }

    public List<CharacterEntity> getCharsInfo() {
        return charsInfo;
    }

    public void setCharsInfo(List<CharacterEntity> charsInfo) {
        this.charsInfo = charsInfo;
    }
}
