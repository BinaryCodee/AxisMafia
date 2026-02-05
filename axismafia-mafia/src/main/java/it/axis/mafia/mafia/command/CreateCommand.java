package it.axis.mafia.mafia.command;

import it.axis.mafia.core.command.AxisSubCommand;
import it.axis.mafia.mafia.manager.MafiaManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateCommand extends AxisSubCommand {
    private final MafiaManager manager;

    public CreateCommand(MafiaManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "create";
    }

    @Override
    public String getPermission() {
        return "axismafia.create";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cOnly players.");
            return;
        }

        if (args.length < 3) {
            sender.sendMessage("§cUsage: /mafia create <name> <tag>");
            return;
        }

        String name = args[1];
        String tag = args[2];

        if (manager.getMafia(name) != null) {
            sender.sendMessage("§cMafia already exists.");
            return;
        }

        manager.createMafia(name, tag);
        sender.sendMessage("§aMafia " + name + " created successfully!");
    }
}
