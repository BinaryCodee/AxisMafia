package it.axis.mafia.reputation.domain.model;

public class ReputationPoints {
    private int value;

    public ReputationPoints(int initial) {
        this.value = initial;
    }

    public void add(int points) {
        this.value += points;
    }

    public void remove(int points) {
        this.value -= points;
    }

    public int getValue() {
        return value;
    }
}
