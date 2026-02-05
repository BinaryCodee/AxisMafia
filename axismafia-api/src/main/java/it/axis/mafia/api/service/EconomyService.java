package it.axis.mafia.api.service;

import it.axis.mafia.api.model.EconomyData;

public interface EconomyService {
    void deposit(EconomyData account, double amount);
    void withdraw(EconomyData account, double amount);
    boolean has(EconomyData account, double amount);
    void set(EconomyData account, double amount);
    
    void depositCustom(EconomyData account, String currency, double amount);
    void withdrawCustom(EconomyData account, String currency, double amount);
    boolean hasCustom(EconomyData account, String currency, double amount);
}
