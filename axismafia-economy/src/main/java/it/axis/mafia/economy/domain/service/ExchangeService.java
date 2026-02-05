package it.axis.mafia.economy.domain.service;

import it.axis.mafia.economy.domain.model.currency.ExchangeRate;

public interface ExchangeService {
    ExchangeRate getRate(String fromCurrency, String toCurrency);
}
