package it.axis.mafia.plugin.loader;

import it.axis.mafia.core.bootstrap.Bootstrapper;
import it.axis.mafia.core.registry.ServiceRegistry;
import org.bukkit.plugin.java.JavaPlugin;

public class AxisMafiaLoader {
    private final JavaPlugin plugin;

    public AxisMafiaLoader(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void load() {
        plugin.getLogger().info("Initializing Enterprise Loader...");

        ServiceRegistry.register(JavaPlugin.class, plugin);
    }
}
