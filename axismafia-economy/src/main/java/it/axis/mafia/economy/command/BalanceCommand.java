package it.axis.mafia.economy.command;

import it.axis.mafia.core.command.AxisSubCommand;
import org.bukkit.command.CommandSender;

public class BalanceCommand extends AxisSubCommand {
    @Override
    public String getName() {
        return "balance";
    }

    @Override
    public String getPermission() {
        return null;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§aBalance: $0");
    }
}
