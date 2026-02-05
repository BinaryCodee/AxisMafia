package it.axis.mafia.territories.application.port.in;

import java.util.concurrent.CompletableFuture;

public interface ConquerTerritoryUseCase {
    CompletableFuture<Void> execute(ConquerTerritoryCommand command);
}
