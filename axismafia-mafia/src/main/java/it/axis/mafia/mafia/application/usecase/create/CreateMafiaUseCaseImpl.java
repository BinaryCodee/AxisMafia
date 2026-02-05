package it.axis.mafia.mafia.application.usecase.create;

import it.axis.mafia.api.exception.mafia.MafiaAlreadyExistsException;
import it.axis.mafia.mafia.manager.MafiaManager;

public class CreateMafiaUseCaseImpl {
    private final MafiaManager mafiaManager;
    private final CreateMafiaOutputPort outputPort;

    public CreateMafiaUseCaseImpl(MafiaManager mafiaManager, CreateMafiaOutputPort outputPort) {
        this.mafiaManager = mafiaManager;
        this.outputPort = outputPort;
    }

    public void execute(CreateMafiaCommand command) {
        if (mafiaManager.getMafia(command.name) != null) {
            outputPort.presentError("Mafia exists");
            return;
        }
        mafiaManager.createMafia(command.name, command.color);
        outputPort.presentSuccess(command.name);
    }
}
