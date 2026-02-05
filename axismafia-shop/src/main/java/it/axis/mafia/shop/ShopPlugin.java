package it.axis.mafia.shop;

import it.axis.mafia.shop.manager.ShopManager;
import org.bukkit.plugin.java.JavaPlugin;

public class ShopPlugin extends JavaPlugin {

    private ShopManager shopManager;

    @Override
    public void onEnable() {
        this.shopManager = new ShopManager();
        getLogger().info("AxisMafia Shop Module initialized.");
    }
}
