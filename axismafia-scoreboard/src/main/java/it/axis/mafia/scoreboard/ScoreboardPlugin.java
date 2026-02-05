package it.axis.mafia.scoreboard;

import it.axis.mafia.scoreboard.manager.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ScoreboardPlugin extends JavaPlugin implements Listener {

    private ScoreboardManager scoreboardManager;

    @Override
    public void onEnable() {
        this.scoreboardManager = new ScoreboardManager();
        getServer().getPluginManager().registerEvents(this, this);

        // Update task (20 ticks = 1s)
        getServer().getScheduler().runTaskTimerAsynchronously(this, () -> {
            scoreboardManager.updateAll();
        }, 20L, 20L);

        getLogger().info("AxisMafia Scoreboard Module initialized.");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        scoreboardManager.createBoard(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        scoreboardManager.removeBoard(event.getPlayer());
    }
}
