package it.axis.mafia.territories.manager;

import it.axis.mafia.api.model.TerritoryData;
import it.axis.mafia.api.service.TerritoryService;
import it.axis.mafia.core.manager.AbstractManager;
import org.bukkit.Chunk;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TerritoryManager extends AbstractManager implements TerritoryService {
    private final Map<String, TerritoryData> territories = new ConcurrentHashMap<>();

    public TerritoryManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onEnable() {
        // Load
    }

    @Override
    public void onDisable() {
        // Save
    }

    @Override
    public void createTerritory(String name, String biome, double revenue) {
        TerritoryData data = new TerritoryData(name, null, 0, 0, biome); // Simplify ctor
        territories.put(name.toLowerCase(), data);
    }

    @Override
    public void setOwner(TerritoryData territory, String mafiaName) {
        // Logic
    }

    @Override
    public TerritoryData getTerritory(Chunk chunk) {
        // Spatial hash lookup
        return null;
    }
}
