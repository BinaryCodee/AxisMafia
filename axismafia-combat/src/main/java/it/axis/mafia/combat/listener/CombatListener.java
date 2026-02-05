package it.axis.mafia.combat.listener;

import it.axis.mafia.combat.manager.CombatManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class CombatListener implements Listener {
    private final CombatManager manager;

    public CombatListener(CombatManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.isCancelled())
            return;
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            manager.tagPlayer((Player) event.getEntity());
            manager.tagPlayer((Player) event.getDamager());
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        if (manager.isInCombat(event.getPlayer())) {
            event.getPlayer().setHealth(0);
        }
    }
}
