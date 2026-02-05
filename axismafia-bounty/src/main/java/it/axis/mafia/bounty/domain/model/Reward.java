package it.axis.mafia.bounty.domain.model;

import java.math.BigDecimal;

public class Reward {
    private final BigDecimal amount;

    public Reward(double amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Reward must be positive");
        this.amount = BigDecimal.valueOf(amount);
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
