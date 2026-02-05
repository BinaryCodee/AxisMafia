package it.axis.mafia.api.usecase.mafia;

import java.util.concurrent.CompletableFuture;

public interface AddMemberUseCase {
    CompletableFuture<Void> execute(String mafiaName, String userId);
}
