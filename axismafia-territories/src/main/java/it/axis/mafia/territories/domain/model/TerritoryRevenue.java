package it.axis.mafia.territories.domain.model;

public class TerritoryRevenue {
    private final double amountPerMinute;

    public TerritoryRevenue(double amount) {
        this.amountPerMinute = amount;
    }

    public double getAmountPerMinute() {
        return amountPerMinute;
    }
}
