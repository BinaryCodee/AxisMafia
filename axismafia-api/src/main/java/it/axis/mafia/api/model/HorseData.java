package it.axis.mafia.api.model;

import java.util.UUID;

public class HorseData {
    private final UUID ownerUuid;
    private final String mafiaName;
    private double speed;
    private double jumpStrength;
    private double health;
    private double experience;
    private int level;

    public HorseData(UUID ownerUuid, String mafiaName) {
        this.ownerUuid = ownerUuid;
        this.mafiaName = mafiaName;
        this.speed = 0.225;
        this.jumpStrength = 0.7;
        this.health = 20.0;
        this.experience = 0;
        this.level = 1;
    }

    public UUID getOwnerUuid() {
        return ownerUuid;
    }

    public String getMafiaName() {
        return mafiaName;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getJumpStrength() {
        return jumpStrength;
    }

    public void setJumpStrength(double jumpStrength) {
        this.jumpStrength = jumpStrength;
    }

    public double getHealth() {
        return health;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getExperience() {
        return experience;
    }

    public void setExperience(double experience) {
        this.experience = experience;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
