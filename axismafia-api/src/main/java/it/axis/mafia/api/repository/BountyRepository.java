package it.axis.mafia.api.repository;

import it.axis.mafia.api.model.BountyData;
import java.util.UUID;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface BountyRepository extends Repository<UUID, BountyData> {

    CompletableFuture<Set<BountyData>> findAllBySetter(UUID setterUuid);
}
