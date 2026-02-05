package it.axis.mafia.api.repository;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface Repository<K, V> {
    CompletableFuture<Void> save(V value);
    CompletableFuture<Optional<V>> findById(K id);
    CompletableFuture<Set<V>> findAll();
    CompletableFuture<Void> delete(K id);
    void cache(V value);
    void invalidate(K id);
}
