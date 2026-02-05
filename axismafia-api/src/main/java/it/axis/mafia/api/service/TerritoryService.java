package it.axis.mafia.api.service;

import it.axis.mafia.api.model.TerritoryData;
import it.axis.mafia.api.model.MafiaData;

public interface TerritoryService {
    void createTerritory(String name, String biome, double revenue);
    void setOwner(TerritoryData territory, MafiaData mafia);
    void clearOwner(TerritoryData territory);
    TerritoryData getTerritoryAt(String world, int x, int z);
}
