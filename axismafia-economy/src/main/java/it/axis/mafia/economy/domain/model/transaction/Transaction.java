package it.axis.mafia.economy.domain.model.transaction;

import it.axis.mafia.economy.domain.model.currency.CurrencyCode;
import java.time.Instant;

public class Transaction {
    private final TransactionId id;
    private final CurrencyCode currency;
    private final double amount;
    private final Instant timestamp;
    private final String from;
    private final String to;

    public Transaction(CurrencyCode currency, double amount, String from, String to) {
        this.id = new TransactionId();
        this.currency = currency;
        this.amount = amount;
        this.from = from;
        this.to = to;
        this.timestamp = Instant.now();
    }
}
