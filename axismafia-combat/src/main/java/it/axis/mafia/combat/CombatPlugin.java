package it.axis.mafia.combat;

import it.axis.mafia.combat.manager.CombatManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class CombatPlugin extends JavaPlugin implements Listener {

    private CombatManager combatManager;
    private static CombatPlugin instance;

    @Override
    public void onEnable() {
        instance = this;
        this.combatManager = new CombatManager();
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("AxisMafia Combat Module initialized.");
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            combatManager.tag((Player) event.getEntity());
            combatManager.tag((Player) event.getDamager());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (combatManager.isInCombat(event.getPlayer())) {
            event.getPlayer().setHealth(0);
            Bukkit.broadcastMessage("§c" + event.getPlayer().getName() + " è uscito in combattimento!");
        }
    }

    public static CombatPlugin getInstance() {
        return instance;
    }

    public CombatManager getCombatManager() {
        return combatManager;
    }
}
