package it.axis.mafia.social;

import it.axis.mafia.social.manager.AllianceManager;
import org.bukkit.plugin.java.JavaPlugin;

public class SocialPlugin extends JavaPlugin {

    private AllianceManager allianceManager;

    @Override
    public void onEnable() {
        this.allianceManager = new AllianceManager();
        getLogger().info("AxisMafia Social Module initialized.");
    }

    public AllianceManager getAllianceManager() {
        return allianceManager;
    }
}
