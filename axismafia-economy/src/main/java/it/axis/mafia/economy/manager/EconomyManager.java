package it.axis.mafia.economy.manager;

import it.axis.mafia.api.service.EconomyService;
import it.axis.mafia.api.model.EconomyData;
import it.axis.mafia.core.manager.AbstractManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EconomyManager extends AbstractManager implements EconomyService {
    private final Map<String, EconomyData> accounts = new ConcurrentHashMap<>();

    public EconomyManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onEnable() {
        // Load from DB
    }

    @Override
    public void onDisable() {
        // Save to DB
    }

    @Override
    public void deposit(EconomyData account, double amount) {
        if (amount <= 0)
            return;
        account.setBalance(account.getBalance() + amount);
    }

    @Override
    public void withdraw(EconomyData account, double amount) {
        if (amount <= 0)
            return;
        account.setBalance(Math.max(0, account.getBalance() - amount));
    }

    @Override
    public boolean has(EconomyData account, double amount) {
        return account.getBalance() >= amount;
    }
}
