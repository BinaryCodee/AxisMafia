package it.axis.mafia.mafia.infrastructure.persistence.sqlite;

import it.axis.mafia.api.repository.MafiaRepository;
import it.axis.mafia.api.model.MafiaData;
import it.axis.mafia.storage.connection.ConnectionFactory;
import it.axis.mafia.mafia.infrastructure.mapper.MafiaDataMapper;
import java.util.concurrent.CompletableFuture;
import java.util.Optional;

public class SqliteMafiaRepository implements MafiaRepository {
    private final ConnectionFactory connectionFactory;
    private final MafiaDataMapper mapper;

    public SqliteMafiaRepository(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        this.mapper = new MafiaDataMapper();
    }

    @Override
    public CompletableFuture<Void> save(MafiaData value) {
        // Implementation of save logic using PreparedStatement
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<Optional<MafiaData>> findById(String s) {
        return CompletableFuture.completedFuture(Optional.empty());
    }

    @Override
    public CompletableFuture<Void> delete(String s) {
        return CompletableFuture.completedFuture(null);
    }

    @Override
    public CompletableFuture<java.util.Set<MafiaData>> findAll() {
        return CompletableFuture.completedFuture(java.util.Collections.emptySet());
    }
}
