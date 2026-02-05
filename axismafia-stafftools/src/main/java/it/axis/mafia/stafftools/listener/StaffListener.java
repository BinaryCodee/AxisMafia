package it.axis.mafia.stafftools.listener;

import it.axis.mafia.stafftools.manager.StaffManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class StaffListener implements Listener {
    private final StaffManager manager;

    public StaffListener(StaffManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        if (manager.isFrozen(event.getPlayer().getUniqueId())) {
            event.setCancelled(true);
        }
    }
}
