package it.axis.mafia.economy.domain.model.transaction;

import java.time.Instant;
import java.util.UUID;

public class TransactionId {
    private final UUID id;

    public TransactionId() {
        this.id = UUID.randomUUID();
    }

    public String toString() {
        return id.toString();
    }
}
