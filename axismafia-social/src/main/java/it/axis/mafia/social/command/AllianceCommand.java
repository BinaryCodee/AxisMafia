package it.axis.mafia.social.command;

import it.axis.mafia.core.command.AxisSubCommand;
import org.bukkit.command.CommandSender;

public class AllianceCommand extends AxisSubCommand {
    @Override
    public String getName() {
        return "alliance";
    }

    @Override
    public String getPermission() {
        return "axismafia.alliance";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§aAlliance request sent!");
    }
}
