package it.axis.mafia.core.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AxisCommandManager implements CommandExecutor, TabCompleter {
    private final Map<String, AxisSubCommand> subCommands = new HashMap<>();

    public void registerSubCommand(AxisSubCommand cmd) {
        subCommands.put(cmd.getName().toLowerCase(), cmd);
        for (String alias : cmd.getAliases()) {
            subCommands.put(alias.toLowerCase(), cmd);
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§cUsage: /" + label + " <subcommand>");
            return true;
        }

        AxisSubCommand cmd = subCommands.get(args[0].toLowerCase());
        if (cmd == null) {
            sender.sendMessage("§cUnknown subcommand.");
            return true;
        }

        if (cmd.getPermission() != null && !sender.hasPermission(cmd.getPermission())) {
            sender.sendMessage("§cNo permission.");
            return true;
        }

        cmd.execute(sender, args);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> list = new ArrayList<>();
            for (String s : subCommands.keySet()) {
                if (s.startsWith(args[0].toLowerCase()))
                    list.add(s);
            }
            return list;
        }

        if (args.length > 1) {
            AxisSubCommand cmd = subCommands.get(args[0].toLowerCase());
            if (cmd != null) {
                return cmd.tabComplete(sender, args);
            }
        }
        return new ArrayList<>();
    }
}
