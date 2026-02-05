package it.axis.mafia.core.listener;

import it.axis.mafia.core.manager.PlayerManager;
import it.axis.mafia.utils.MessageUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SessionListener implements Listener {

    private final PlayerManager playerManager;

    public SessionListener(PlayerManager playerManager) {
        this.playerManager = playerManager;
    }

    @EventHandler
    public void onAsyncLogin(AsyncPlayerPreLoginEvent event) {

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        playerManager.loadPlayer(event.getPlayer().getUniqueId(), event.getPlayer().getName());
        String joinMsg = "&8[&a+&8] &7" + event.getPlayer().getName();
        event.setJoinMessage(MessageUtils.color(joinMsg));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        playerManager.unloadPlayer(event.getPlayer().getUniqueId());
        String quitMsg = "&8[&c-&8] &7" + event.getPlayer().getName();
        event.setQuitMessage(MessageUtils.color(quitMsg));
    }
}
