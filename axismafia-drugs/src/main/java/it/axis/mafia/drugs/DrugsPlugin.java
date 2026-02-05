package it.axis.mafia.drugs;

import it.axis.mafia.drugs.manager.DrugManager;
import org.bukkit.plugin.java.JavaPlugin;

public class DrugsPlugin extends JavaPlugin {

    private DrugManager drugManager;

    @Override
    public void onEnable() {
        this.drugManager = new DrugManager();
        getLogger().info("AxisMafia Drugs Module initialized.");
    }
}
