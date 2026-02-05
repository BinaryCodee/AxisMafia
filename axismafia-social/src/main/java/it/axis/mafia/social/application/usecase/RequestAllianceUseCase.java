package it.axis.mafia.social.application.usecase;

import java.util.concurrent.CompletableFuture;

public interface RequestAllianceUseCase {
    CompletableFuture<Void> execute(String requester, String target);
}
