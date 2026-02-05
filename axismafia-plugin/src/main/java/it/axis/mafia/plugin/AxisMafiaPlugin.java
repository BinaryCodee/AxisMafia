package it.axis.mafia.plugin;

import it.axis.mafia.core.module.AxisModule;
import it.axis.mafia.mafia.MafiaModule;
import it.axis.mafia.storage.connection.ConnectionFactory;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.ArrayList;
import java.util.List;

public class AxisMafiaPlugin extends JavaPlugin {
    private final List<AxisModule> modules = new ArrayList<>();
    private ConnectionFactory connectionFactory;

    @Override
    public void onEnable() {
        connectionFactory = new ConnectionFactory(getDataFolder());

        registerModule(new MafiaModule(this, connectionFactory));

        for (AxisModule module : modules) {
            getLogger().info("Enabling " + module.getName() + "...");
            try {
                module.enable();
            } catch (Exception e) {
                getLogger().severe("Failed to enable " + module.getName());
                e.printStackTrace();
                if (module.isCritical()) {
                    getServer().getPluginManager().disablePlugin(this);
                    return;
                }
            }
        }
    }

    @Override
    public void onDisable() {
        for (int i = modules.size() - 1; i >= 0; i--) {
            modules.get(i).disable();
        }
        if (connectionFactory != null)
            connectionFactory.shutdown();
    }

    private void registerModule(AxisModule module) {
        modules.add(module);
    }
}
