package it.axis.mafia.scoreboard.manager;

import it.axis.mafia.core.manager.AbstractManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class ScoreboardManager extends AbstractManager {
    public ScoreboardManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onEnable() {
        Bukkit.getScheduler().runTaskTimer(plugin, this::updateAll, 20L, 20L);
    }

    @Override
    public void onDisable() {
    }

    private void updateAll() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            update(p);
        }
    }

    private void update(Player p) {

    }
}
