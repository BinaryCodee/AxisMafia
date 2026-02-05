package it.axis.mafia.shop.domain.model;

import it.axis.mafia.api.domain.shared.value.Currency;
import java.math.BigDecimal;

public class Price {
    private final BigDecimal amount;
    private final Currency currency;

    public Price(double amount, Currency currency) {
        if (amount < 0)
            throw new IllegalArgumentException("Negative price");
        this.amount = BigDecimal.valueOf(amount);
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public Currency getCurrency() {
        return currency;
    }
}
