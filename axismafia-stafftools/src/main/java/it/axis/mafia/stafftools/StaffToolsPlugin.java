package it.axis.mafia.stafftools;

import it.axis.mafia.stafftools.manager.StaffManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffToolsPlugin extends JavaPlugin {

    private StaffManager staffManager;

    @Override
    public void onEnable() {
        this.staffManager = new StaffManager();
        getLogger().info("AxisMafia StaffTools Module initialized.");
    }
}
