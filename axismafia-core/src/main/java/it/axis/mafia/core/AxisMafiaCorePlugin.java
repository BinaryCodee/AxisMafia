package it.axis.mafia.core;

import it.axis.mafia.core.listener.SessionListener;
import it.axis.mafia.core.manager.PlayerManager;
import it.axis.mafia.storage.StoragePlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class AxisMafiaCorePlugin extends JavaPlugin {

    private PlayerManager playerManager;
    private static AxisMafiaCorePlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        if (StoragePlugin.getInstance() == null) {
            getLogger().severe("StoragePlugin not found! Disabling Core.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.playerManager = new PlayerManager(StoragePlugin.getInstance().getPlayerRepository());

        getServer().getPluginManager().registerEvents(new SessionListener(playerManager), this);

        getLogger().info("AxisMafia Core initialized.");
    }

    @Override
    public void onDisable() {
        if (playerManager != null) {
            playerManager.saveAll();
        }
    }

    public static AxisMafiaCorePlugin getInstance() {
        return instance;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }
}
