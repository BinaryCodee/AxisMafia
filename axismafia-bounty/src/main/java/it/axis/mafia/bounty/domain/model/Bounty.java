package it.axis.mafia.bounty.domain.model;

import java.time.Instant;
import java.util.UUID;

public class Bounty {
    private final BountyId id;
    private final UUID targetId;
    private final UUID setterId;
    private final Reward reward;
    private final Instant creationTime;

    public Bounty(UUID targetId, UUID setterId, Reward reward) {
        this.id = new BountyId();
        this.targetId = targetId;
        this.setterId = setterId;
        this.reward = reward;
        this.creationTime = Instant.now();
    }

    public BountyId getId() {
        return id;
    }

    public UUID getTargetId() {
        return targetId;
    }

    public Reward getReward() {
        return reward;
    }
}
