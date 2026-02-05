package it.axis.mafia.api.model;

import java.util.HashMap;
import java.util.Map;

public class EconomyData {
    private double balance;
    private final Map<String, Double> customCurrencies;
    private long lastDailyPizzo;

    public EconomyData() {
        this.balance = 0.0;
        this.customCurrencies = new HashMap<>();
        this.lastDailyPizzo = 0;
    }

    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    
    public Map<String, Double> getCustomCurrencies() { return customCurrencies; }
    
    public double getCustomCurrency(String currency) {
        return customCurrencies.getOrDefault(currency, 0.0);
    }
    
    public void setCustomCurrency(String currency, double amount) {
        customCurrencies.put(currency, amount);
    }
    
    public void addCustomCurrency(String currency, double amount) {
        customCurrencies.merge(currency, amount, Double::sum);
    }
    
    public void removeCustomCurrency(String currency, double amount) {
        customCurrencies.merge(currency, -amount, Double::sum);
    }

    public long getLastDailyPizzo() { return lastDailyPizzo; }
    public void setLastDailyPizzo(long lastDailyPizzo) { this.lastDailyPizzo = lastDailyPizzo; }
}
