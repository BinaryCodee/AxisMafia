package it.axis.mafia.storage;

import it.axis.mafia.storage.database.DatabaseManager;
import it.axis.mafia.storage.repository.MafiaRepositoryImpl;
import it.axis.mafia.storage.repository.PlayerRepositoryImpl;
import it.axis.mafia.storage.repository.TerritoryRepositoryImpl;
import org.bukkit.plugin.java.JavaPlugin;

public class StoragePlugin extends JavaPlugin {

    private DatabaseManager databaseManager;
    private PlayerRepositoryImpl playerRepository;
    private MafiaRepositoryImpl mafiaRepository;
    private TerritoryRepositoryImpl territoryRepository;

    private static StoragePlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        this.databaseManager = new DatabaseManager(getDataFolder());

        this.playerRepository = new PlayerRepositoryImpl(databaseManager);
        this.mafiaRepository = new MafiaRepositoryImpl(databaseManager);
        this.territoryRepository = new TerritoryRepositoryImpl(databaseManager);

        getLogger().info("AxisMafia Storage initialized.");
    }

    @Override
    public void onDisable() {
        if (databaseManager != null) {
            databaseManager.close();
        }
    }

    public static StoragePlugin getInstance() {
        return instance;
    }

    public PlayerRepositoryImpl getPlayerRepository() {
        return playerRepository;
    }

    public MafiaRepositoryImpl getMafiaRepository() {
        return mafiaRepository;
    }

    public TerritoryRepositoryImpl getTerritoryRepository() {
        return territoryRepository;
    }
}
