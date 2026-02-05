package it.axis.mafia.economy.service;

import it.axis.mafia.api.model.EconomyData;
import it.axis.mafia.api.service.EconomyService;

public class EconomyServiceImpl implements EconomyService {

    @Override
    public void deposit(EconomyData account, double amount) {
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdraw(EconomyData account, double amount) {
        account.setBalance(account.getBalance() - amount);
    }

    @Override
    public boolean has(EconomyData account, double amount) {
        return account.getBalance() >= amount;
    }

    @Override
    public void set(EconomyData account, double amount) {
        account.setBalance(amount);
    }

    @Override
    public void depositCustom(EconomyData account, String currency, double amount) {
        account.addCustomCurrency(currency, amount);
    }

    @Override
    public void withdrawCustom(EconomyData account, String currency, double amount) {
        account.removeCustomCurrency(currency, amount);
    }

    @Override
    public boolean hasCustom(EconomyData account, String currency, double amount) {
        return account.getCustomCurrency(currency) >= amount;
    }
}
