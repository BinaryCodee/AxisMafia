package it.axis.mafia.horses;

import it.axis.mafia.storage.StoragePlugin;
import it.axis.mafia.horses.manager.HorseManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HorsesPlugin extends JavaPlugin {

    private HorseManager horseManager;

    @Override
    public void onEnable() {
        if (StoragePlugin.getInstance() == null)
            return;

        this.horseManager = new HorseManager(StoragePlugin.getInstance().getHorseRepository());

        getLogger().info("AxisMafia Horses Module initialized.");
    }
}
