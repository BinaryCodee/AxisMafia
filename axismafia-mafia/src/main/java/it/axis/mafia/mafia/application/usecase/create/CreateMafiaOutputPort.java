package it.axis.mafia.mafia.application.usecase.create;

import java.util.concurrent.CompletableFuture;

public interface CreateMafiaOutputPort {
    void presentSuccess(String mafiaName);

    void presentError(String error);
}
