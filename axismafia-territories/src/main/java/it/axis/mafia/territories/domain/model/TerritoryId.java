package it.axis.mafia.territories.domain.model;

import java.io.Serializable;
import java.util.UUID;

public class TerritoryId implements Serializable {
    private final UUID id;

    public TerritoryId() {
        this.id = UUID.randomUUID();
    }

    public TerritoryId(UUID id) {
        this.id = id;
    }

    public UUID getValue() {
        return id;
    }
}
