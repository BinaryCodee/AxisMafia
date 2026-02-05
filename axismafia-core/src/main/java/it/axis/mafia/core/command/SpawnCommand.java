package it.axis.mafia.core.command;

import it.axis.mafia.utils.MessageUtils;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        Player player = (Player) sender;

        if (label.equalsIgnoreCase("setspawn")) {
            if (!player.hasPermission("axismafia.admin")) {
                MessageUtils.send(player, "&cNo permission.");
                return true;
            }
            player.getWorld().setSpawnLocation(player.getLocation());
            MessageUtils.send(player, "&aSpawn aggiornato!");
            return true;
        }

        if (label.equalsIgnoreCase("spawn")) {
            Location spawn = player.getWorld().getSpawnLocation();

            player.teleport(spawn);
            MessageUtils.send(player, "&aTeleportato allo spawn!");
            return true;
        }

        return false;
    }
}
