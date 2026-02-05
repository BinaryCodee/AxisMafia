package it.axis.mafia.combat.domain.model;

import java.util.UUID;

public class CombatSession {
    private final CombatSessionId id;
    private final UUID playerUuid;
    private final UUID lastAttackerUuid;
    private CombatTagDuration duration;

    public CombatSession(UUID playerUuid, UUID attackerUuid, long durationMillis) {
        this.id = new CombatSessionId();
        this.playerUuid = playerUuid;
        this.lastAttackerUuid = attackerUuid;
        this.duration = new CombatTagDuration(durationMillis);
    }

    public void refresh(long durationMillis) {
        this.duration = new CombatTagDuration(durationMillis);
    }

    public boolean isActive() {
        return !duration.isExpired();
    }
}
