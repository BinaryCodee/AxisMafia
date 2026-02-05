package it.axis.mafia.api.domain.user.model;

import it.axis.mafia.api.domain.shared.value.Currency;
import java.util.Map;

public interface UserFinancials {
    double getBalance();

    void deposit(double amount);

    void withdraw(double amount);

    boolean has(double amount);

    Map<Currency, Double> getCustomCurrencies();

    double getCurrency(Currency currency);
}
