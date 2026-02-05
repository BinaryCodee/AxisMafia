package it.axis.mafia.stafftools.domain.model;

import java.util.UUID;

public class FrozenState {
    private final UUID targetId;
    private final UUID staffId;
    private final long timestamp;

    public FrozenState(UUID targetId, UUID staffId) {
        this.targetId = targetId;
        this.staffId = staffId;
        this.timestamp = System.currentTimeMillis();
    }

    public UUID getTargetId() {
        return targetId;
    }

    public UUID getStaffId() {
        return staffId;
    }
}
