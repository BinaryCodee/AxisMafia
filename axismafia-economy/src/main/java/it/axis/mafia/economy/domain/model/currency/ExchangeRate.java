package it.axis.mafia.economy.domain.model.currency;

public class ExchangeRate {
    private final double rate;

    public ExchangeRate(double rate) {
        this.rate = rate;
    }

    public double convert(double amount) {
        return amount * rate;
    }
}
