package it.axis.mafia.mafia.command;

import it.axis.mafia.core.command.AxisSubCommand;
import it.axis.mafia.mafia.manager.MafiaManager;
import org.bukkit.command.CommandSender;

public class DisbandCommand extends AxisSubCommand {
    private final MafiaManager manager;

    public DisbandCommand(MafiaManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "disband";
    }

    @Override
    public String getPermission() {
        return "axismafia.disband";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length < 2) {
            sender.sendMessage("§cUsage: /mafia disband <name>");
            return;
        }

        String name = args[1];
        if (manager.getMafia(name) == null) {
            sender.sendMessage("§cMafia not found.");
            return;
        }

        manager.disbandMafia(name);
        sender.sendMessage("§aMafia " + name + " disbanded.");
    }
}
