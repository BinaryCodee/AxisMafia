package it.axis.mafia.shop.domain.model;

import java.io.Serializable;
import java.util.UUID;

public class ShopId implements Serializable {
    private final UUID id;

    public ShopId() {
        this.id = UUID.randomUUID();
    }

    public UUID getValue() {
        return id;
    }
}
