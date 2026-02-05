package it.axis.mafia.drugs.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class DrugListener implements Listener {
    @EventHandler
    public void onConsume(PlayerItemConsumeEvent event) {
        // Drug logic
    }
}
