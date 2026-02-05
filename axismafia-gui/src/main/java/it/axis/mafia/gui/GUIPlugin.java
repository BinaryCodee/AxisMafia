package it.axis.mafia.gui;

import it.axis.mafia.gui.manager.GUIManager;
import org.bukkit.plugin.java.JavaPlugin;

public class GUIPlugin extends JavaPlugin {

    private GUIManager guiManager;
    private static GUIPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        this.guiManager = new GUIManager();
        getServer().getPluginManager().registerEvents(guiManager, this);
        getLogger().info("AxisMafia GUI Module initialized.");
    }

    public static GUIPlugin getInstance() {
        return instance;
    }

    public GUIManager getGuiManager() {
        return guiManager;
    }
}
