package it.axis.mafia.drugs.domain.model;

public class DrugPurity {
    private final int percentage;

    public DrugPurity(int percentage) {
        if (percentage < 0 || percentage > 100)
            throw new IllegalArgumentException("Purity 0-100");
        this.percentage = percentage;
    }

    public int getValue() {
        return percentage;
    }
}
