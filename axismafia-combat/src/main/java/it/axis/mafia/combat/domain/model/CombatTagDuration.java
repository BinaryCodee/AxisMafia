package it.axis.mafia.combat.domain.model;

import java.time.Instant;

public class CombatTagDuration {
    private final Instant endTime;

    public CombatTagDuration(long durationMillis) {
        this.endTime = Instant.now().plusMillis(durationMillis);
    }

    public boolean isExpired() {
        return Instant.now().isAfter(endTime);
    }

    public long getRemainingMillis() {
        return Math.max(0, endTime.toEpochMilli() - Instant.now().toEpochMilli());
    }
}
