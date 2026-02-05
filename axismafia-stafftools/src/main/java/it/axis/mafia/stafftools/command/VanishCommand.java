package it.axis.mafia.stafftools.command;

import it.axis.mafia.core.command.AxisSubCommand;
import it.axis.mafia.stafftools.manager.StaffManager;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand extends AxisSubCommand {
    private final StaffManager manager;

    public VanishCommand(StaffManager manager) {
        this.manager = manager;
    }

    @Override
    public String getName() {
        return "vanish";
    }

    @Override
    public String getPermission() {
        return "axismafia.vanish";
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender instanceof Player)
            manager.toggleVanish((Player) sender);
    }
}
