package it.axis.mafia.storage.cache;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class LocalMemoryCache<K, V> implements Cache<K, V> {
    private final Map<K, V> map = new ConcurrentHashMap<>();

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public Optional<V> get(K key) {
        return Optional.ofNullable(map.get(key));
    }

    @Override
    public void invalidate(K key) {
        map.remove(key);
    }

    @Override
    public void clear() {
        map.clear();
    }
}
