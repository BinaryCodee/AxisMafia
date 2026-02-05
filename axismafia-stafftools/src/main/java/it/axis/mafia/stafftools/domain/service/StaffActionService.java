package it.axis.mafia.stafftools.domain.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface StaffActionService {
    CompletableFuture<Void> toggleStaffMode(UUID staffId);

    CompletableFuture<Void> toggleVanish(UUID staffId);

    CompletableFuture<Void> freezePlayer(UUID targetId, UUID staffId);

    CompletableFuture<Void> unfreezePlayer(UUID targetId, UUID staffId);
}
