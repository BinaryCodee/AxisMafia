package it.axis.mafia.reputation;

import it.axis.mafia.reputation.manager.ReputationManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ReputationPlugin extends JavaPlugin {

    private ReputationManager reputationManager;
    private static ReputationPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        this.reputationManager = new ReputationManager();
        getLogger().info("AxisMafia Reputation Module initialized.");
    }

    public static ReputationPlugin getInstance() {
        return instance;
    }

    public ReputationManager getReputationManager() {
        return reputationManager;
    }
}
