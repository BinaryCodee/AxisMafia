package it.axis.mafia.stafftools.manager;

import it.axis.mafia.core.manager.AbstractManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class StaffManager extends AbstractManager {
    private final Set<UUID> vanished = new HashSet<>();
    private final Set<UUID> staffMode = new HashSet<>();
    private final Set<UUID> frozen = new HashSet<>();

    public StaffManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }

    public void toggleVanish(Player player) {
        if (vanished.contains(player.getUniqueId())) {
            vanished.remove(player.getUniqueId());
            for (Player p : player.getServer().getOnlinePlayers())
                p.showPlayer(plugin, player);
            player.sendMessage("§aVanish disabled");
        } else {
            vanished.add(player.getUniqueId());
            for (Player p : player.getServer().getOnlinePlayers())
                p.hidePlayer(plugin, player);
            player.sendMessage("§aVanish enabled");
        }
    }

    public void toggleStaffMode(Player player) {
        if (staffMode.contains(player.getUniqueId())) {
            staffMode.remove(player.getUniqueId());
            player.getInventory().clear();
            player.sendMessage("§aStaff mode disabled");
        } else {
            staffMode.add(player.getUniqueId());
            player.getInventory().clear();

            player.sendMessage("§aStaff mode enabled");
        }
    }

    public void toggleFreeze(Player target) {
        if (frozen.contains(target.getUniqueId())) {
            frozen.remove(target.getUniqueId());
            target.sendMessage("§aYou have been unfrozen.");
        } else {
            frozen.add(target.getUniqueId());
            target.sendMessage("§cYou have been frozen.");
        }
    }

    public boolean isFrozen(UUID uuid) {
        return frozen.contains(uuid);
    }
}
