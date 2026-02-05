package it.axis.mafia.core.manager;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

public abstract class AbstractManager {
    protected final JavaPlugin plugin;
    protected final Logger logger;

    public AbstractManager(JavaPlugin plugin) {
        this.plugin = plugin;
        this.logger = plugin.getLogger();
    }

    public abstract void onEnable();

    public abstract void onDisable();

    protected void log(String message) {
        logger.info("[" + getClass().getSimpleName() + "] " + message);
    }
}
