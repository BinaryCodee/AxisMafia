package it.axis.mafia.bounty.application.port.in;

import java.util.concurrent.CompletableFuture;

public interface PlaceBountyUseCase {
    CompletableFuture<Void> execute(String targetUuid, String setterUuid, double amount);
}
