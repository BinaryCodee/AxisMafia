package it.axis.mafia.horses.domain.model;

import java.util.UUID;

public class CustomHorse {
    private final UUID entityId;
    private final HorseSpeed speed;
    private final HorseJumpStrength jumpStrength;

    public CustomHorse(UUID entityId, double speed, double jump) {
        this.entityId = entityId;
        this.speed = new HorseSpeed(speed);
        this.jumpStrength = new HorseJumpStrength(jump);
    }

    public HorseSpeed getSpeed() {
        return speed;
    }

    public HorseJumpStrength getJumpStrength() {
        return jumpStrength;
    }
}
