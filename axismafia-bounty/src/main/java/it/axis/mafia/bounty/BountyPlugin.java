package it.axis.mafia.bounty;

import it.axis.mafia.storage.StoragePlugin;
import it.axis.mafia.bounty.manager.BountyManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BountyPlugin extends JavaPlugin {

    private BountyManager bountyManager;

    @Override
    public void onEnable() {
        if (StoragePlugin.getInstance() == null)
            return;

        this.bountyManager = new BountyManager(StoragePlugin.getInstance().getBountyRepository());
        getLogger().info("AxisMafia Bounty Module initialized.");
    }
}
