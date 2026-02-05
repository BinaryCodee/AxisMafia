package it.axis.mafia.api.usecase.mafia;

import java.util.concurrent.CompletableFuture;

public interface DisbandMafiaUseCase {
    CompletableFuture<Void> execute(String mafiaName);
}
