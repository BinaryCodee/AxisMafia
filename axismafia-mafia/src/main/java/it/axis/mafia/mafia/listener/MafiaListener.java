package it.axis.mafia.mafia.listener;

import it.axis.mafia.api.event.mafia.MafiaCreationEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MafiaListener implements Listener {

    @EventHandler
    public void onCreate(MafiaCreationEvent event) {
        Bukkit.broadcastMessage("§eA new Mafia has been formed: §6" + event.getName());
    }
}
