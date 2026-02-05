package it.axis.mafia.territories;

import it.axis.mafia.storage.StoragePlugin;
import it.axis.mafia.territories.manager.TerritoryManager;
import it.axis.mafia.territories.service.TerritoryServiceImpl;
import org.bukkit.plugin.java.JavaPlugin;

public class TerritoriesPlugin extends JavaPlugin {

    private TerritoryManager manager;
    private TerritoryServiceImpl service;
    private static TerritoriesPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        if (StoragePlugin.getInstance() == null) {
            getLogger().severe("StoragePlugin missing!");
            return;
        }

        this.manager = new TerritoryManager(StoragePlugin.getInstance().getTerritoryRepository());
        this.service = new TerritoryServiceImpl(manager);

        manager.loadAll();
        getLogger().info("AxisMafia Territories Module initialized.");
    }

    public static TerritoriesPlugin getInstance() {
        return instance;
    }

    public TerritoryServiceImpl getService() {
        return service;
    }
}
