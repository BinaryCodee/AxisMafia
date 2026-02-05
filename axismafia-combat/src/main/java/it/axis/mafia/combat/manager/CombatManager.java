package it.axis.mafia.combat.manager;

import it.axis.mafia.core.manager.AbstractManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CombatManager extends AbstractManager {
    private final Map<UUID, Long> taggedPlayers = new ConcurrentHashMap<>();
    private static final long TAG_DURATION_MS = 15000;

    public CombatManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onEnable() {
        plugin.getServer().getScheduler().runTaskTimerAsynchronously(plugin, this::cleanup, 20L, 20L);
    }

    @Override
    public void onDisable() {
        taggedPlayers.clear();
    }

    public void tagPlayer(Player player) {
        taggedPlayers.put(player.getUniqueId(), System.currentTimeMillis() + TAG_DURATION_MS);
        player.sendMessage("§cYou are now in combat!");
    }

    public void untagPlayer(Player player) {
        if (taggedPlayers.remove(player.getUniqueId()) != null) {
            player.sendMessage("§aYou are no longer in combat.");
        }
    }

    public boolean isInCombat(Player player) {
        return taggedPlayers.containsKey(player.getUniqueId());
    }

    private void cleanup() {
        long now = System.currentTimeMillis();
        taggedPlayers.entrySet().removeIf(entry -> {
            boolean expired = entry.getValue() < now;
            if (expired) {
                Player p = plugin.getServer().getPlayer(entry.getKey());
                if (p != null)
                    p.sendMessage("§aYou are no longer in combat.");
            }
            return expired;
        });
    }
}
