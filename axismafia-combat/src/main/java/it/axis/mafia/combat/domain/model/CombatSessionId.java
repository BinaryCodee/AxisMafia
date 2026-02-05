package it.axis.mafia.combat.domain.model;

import java.io.Serializable;
import java.util.UUID;

public class CombatSessionId implements Serializable {
    private final UUID id;

    public CombatSessionId() {
        this.id = UUID.randomUUID();
    }

    public UUID getValue() {
        return id;
    }
}
