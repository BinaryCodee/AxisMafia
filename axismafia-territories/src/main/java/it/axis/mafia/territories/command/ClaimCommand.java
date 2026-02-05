package it.axis.mafia.territories.command;

import it.axis.mafia.core.command.AxisSubCommand;
import org.bukkit.command.CommandSender;

public class ClaimCommand extends AxisSubCommand {
    @Override
    public String getName() {
        return "claim";
    }

    @Override
    public String getPermission() {
        return "axismafia.claim";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§aClaimed!");
    }
}
