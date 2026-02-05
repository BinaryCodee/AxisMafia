package it.axis.mafia.mafia.adapter.controller.command;

import it.axis.mafia.mafia.application.usecase.create.CreateMafiaCommand;
import it.axis.mafia.mafia.application.usecase.create.CreateMafiaOutputPort;
import it.axis.mafia.mafia.application.usecase.create.CreateMafiaUseCaseImpl;
import it.axis.mafia.mafia.manager.MafiaManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MafiaCreateCommandExecutor implements CommandExecutor, CreateMafiaOutputPort {

    private final MafiaManager manager;

    public MafiaCreateCommandExecutor(MafiaManager manager) {
        this.manager = manager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player))
            return false;
        if (args.length < 2)
            return false;

        CreateMafiaUseCaseImpl useCase = new CreateMafiaUseCaseImpl(manager, this);
        useCase.execute(new CreateMafiaCommand(args[0], args[1], ((Player) sender).getUniqueId().toString()));
        return true;
    }

    @Override
    public void presentSuccess(String mafiaName) {

    }

    @Override
    public void presentError(String error) {

    }
}
