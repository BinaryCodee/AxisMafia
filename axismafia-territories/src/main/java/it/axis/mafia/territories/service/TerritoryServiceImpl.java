package it.axis.mafia.territories.service;

import it.axis.mafia.api.model.MafiaData;
import it.axis.mafia.api.model.TerritoryData;
import it.axis.mafia.api.service.TerritoryService;
import it.axis.mafia.territories.manager.TerritoryManager;

public class TerritoryServiceImpl implements TerritoryService {

    private final TerritoryManager manager;

    public TerritoryServiceImpl(TerritoryManager manager) {
        this.manager = manager;
    }

    @Override
    public void createTerritory(String name, String biome, double revenue) {
        manager.createTerritory(name, biome, revenue);
    }

    @Override
    public void setOwner(TerritoryData territory, MafiaData mafia) {
        territory.setOwnerMafia(mafia.getName());
        manager.save(territory);
    }

    @Override
    public void clearOwner(TerritoryData territory) {
        territory.setOwnerMafia(null);
        manager.save(territory);
    }

    @Override
    public TerritoryData getTerritoryAt(String world, int x, int z) {
        // Simple logic: iterate all territories and check bounds
        // In prod, use spatial hashing or chunk map
        return manager.getAll().stream()
                .filter(t -> t.getWorldName().equals(world))
                .filter(t -> x >= t.getMinX() && x <= t.getMaxX() && z >= t.getMinZ() && z <= t.getMaxZ())
                .findFirst().orElse(null);
    }
}
