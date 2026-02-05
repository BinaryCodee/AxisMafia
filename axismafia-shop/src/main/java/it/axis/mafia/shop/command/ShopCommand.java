package it.axis.mafia.shop.command;

import it.axis.mafia.core.command.AxisSubCommand;
import org.bukkit.command.CommandSender;

public class ShopCommand extends AxisSubCommand {
    @Override
    public String getName() {
        return "shop";
    }

    @Override
    public String getPermission() {
        return "axismafia.shop";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        sender.sendMessage("§aOpening shop...");
    }
}
