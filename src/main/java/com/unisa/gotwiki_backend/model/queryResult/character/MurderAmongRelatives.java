package com.unisa.gotwiki_backend.model.queryResult.character;

import com.unisa.gotwiki_backend.model.CharacterEntity;
import com.unisa.gotwiki_backend.model.KilledRelationshipEntity;
import org.springframework.data.neo4j.annotation.QueryResult;

@QueryResult
public class MurderAmongRelatives {
    private CharacterEntity killer;
    private CharacterEntity killed;
    private KilledRelationshipEntity murder;

    /* Getters & Setters */

    public CharacterEntity getKiller() {
        return killer;
    }

    public void setKiller(CharacterEntity killer) {
        this.killer = killer;
    }

    public CharacterEntity getKilled() {
        return killed;
    }

    public void setKilled(CharacterEntity killed) {
        this.killed = killed;
    }

    public KilledRelationshipEntity getMurder() {
        return murder;
    }

    public void setMurder(KilledRelationshipEntity murder) {
        this.murder = murder;
    }

    /* Overrided methods */

    @Override
    public String toString() {
        return "MurderAmongRelatives{" +
                "killer=" + killer.getName() +
                ", killed=" + killed.getName() +
                ", murder=" + murder +
                '}';
    }
}
