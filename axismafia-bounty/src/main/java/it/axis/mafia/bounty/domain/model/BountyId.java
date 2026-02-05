package it.axis.mafia.bounty.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class BountyId implements Serializable {
    private final UUID id;

    public BountyId() {
        this.id = UUID.randomUUID();
    }

    public UUID getValue() {
        return id;
    }
}
