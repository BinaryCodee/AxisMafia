package it.axis.mafia.drugs.domain.model;

public class AddictionLevel {
    private double level;

    public AddictionLevel() {
        this.level = 0;
    }

    public void increase(double amount) {
        this.level = Math.min(100, level + amount);
    }

    public void decrease(double amount) {
        this.level = Math.max(0, level - amount);
    }

    public double getValue() {
        return level;
    }
}
