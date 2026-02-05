package it.axis.mafia.bounty.command;

import it.axis.mafia.core.command.AxisSubCommand;
import org.bukkit.command.CommandSender;

public class PlaceBountyCommand extends AxisSubCommand {
    @Override
    public String getName() {
        return "place";
    }

    @Override
    public String getPermission() {
        return "axismafia.bounty.place";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§aBounty placed!");
    }
}
