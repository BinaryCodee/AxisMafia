package it.axis.mafia.api.domain.user.model;

import it.axis.mafia.api.domain.shared.value.Currency;
import java.util.concurrent.ConcurrentHashMap;
import java.util.Collections;
import java.util.Map;

public class UserFinancialsImpl extends AbstractUserComponent implements UserFinancials {

    private double balance;
    private final Map<Currency, Double> currencies;

    public UserFinancialsImpl() {
        this.balance = 0.0;
        this.currencies = new ConcurrentHashMap<>();
    }

    @Override
    public double getBalance() {
        synchronized (lock) {
            return balance;
        }
    }

    @Override
    public void deposit(double amount) {
        synchronized (lock) {
            this.balance += amount;
        }
    }

    @Override
    public void withdraw(double amount) {
        synchronized (lock) {
            this.balance -= amount;
        }
    }

    @Override
    public boolean has(double amount) {
        synchronized (lock) {
            return this.balance >= amount;
        }
    }

    @Override
    public Map<Currency, Double> getCustomCurrencies() {
        return Collections.unmodifiableMap(currencies);
    }

    @Override
    public double getCurrency(Currency currency) {
        return currencies.getOrDefault(currency, 0.0);
    }
}
