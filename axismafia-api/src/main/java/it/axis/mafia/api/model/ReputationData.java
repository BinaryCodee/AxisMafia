package it.axis.mafia.api.model;

import it.axis.mafia.api.enums.ReputationType;

public class ReputationData {
    private ReputationType type;
    private int points;

    public ReputationData() {
        this.type = ReputationType.NEUTRALE;
        this.points = 0;
    }

    public ReputationType getType() { return type; }
    public void setType(ReputationType type) { this.type = type; }

    public int getPoints() { return points; }
    public void setPoints(int points) { this.points = points; }
    
    public void addPoints(int amount) {
        this.points += amount;
    }
    
    public void removePoints(int amount) {
        this.points -= amount;
    }
}
