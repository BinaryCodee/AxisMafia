package it.axis.mafia.api.model;

import java.util.UUID;

public class BountyData {
    private final UUID targetUuid;
    private final UUID setterUuid;
    private final double amount;
    private final long timestamp;

    public BountyData(UUID targetUuid, UUID setterUuid, double amount) {
        this.targetUuid = targetUuid;
        this.setterUuid = setterUuid;
        this.amount = amount;
        this.timestamp = System.currentTimeMillis();
    }

    public UUID getTargetUuid() { return targetUuid; }
    public UUID getSetterUuid() { return setterUuid; }
    public double getAmount() { return amount; }
    public long getTimestamp() { return timestamp; }
}
