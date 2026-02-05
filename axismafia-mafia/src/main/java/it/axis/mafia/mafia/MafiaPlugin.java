package it.axis.mafia.mafia;

import it.axis.mafia.mafia.manager.MafiaManager;
import it.axis.mafia.mafia.manager.RankManager;
import it.axis.mafia.mafia.service.MafiaServiceImpl;
import it.axis.mafia.storage.StoragePlugin;
import org.bukkit.plugin.java.JavaPlugin;

public class MafiaPlugin extends JavaPlugin {

    private MafiaManager mafiaManager;
    private RankManager rankManager;
    private MafiaServiceImpl mafiaService;
    private static MafiaPlugin instance;

    @Override
    public void onEnable() {
        instance = this;

        if (StoragePlugin.getInstance() == null) {
            getLogger().severe("StoragePlugin missing!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.mafiaManager = new MafiaManager(StoragePlugin.getInstance().getMafiaRepository());
        this.rankManager = new RankManager();
        this.mafiaService = new MafiaServiceImpl(mafiaManager, rankManager);

        mafiaManager.loadAll().thenRun(() -> {
            getLogger().info("Mafias loaded.");
        });

        getLogger().info("AxisMafia Mafia Module initialized.");
    }

    public static MafiaPlugin getInstance() {
        return instance;
    }

    public MafiaService getMafiaService() {
        return mafiaService;
    }

    public MafiaManager getMafiaManager() {
        return mafiaManager;
    }
}
