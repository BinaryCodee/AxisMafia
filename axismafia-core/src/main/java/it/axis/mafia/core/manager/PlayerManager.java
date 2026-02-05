package it.axis.mafia.core.manager;

import it.axis.mafia.api.model.PlayerData;
import it.axis.mafia.api.repository.PlayerRepository;
import org.bukkit.Bukkit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class PlayerManager {

    private final PlayerRepository repository;
    private final Map<UUID, PlayerData> sessionCache = new ConcurrentHashMap<>();

    public PlayerManager(PlayerRepository repository) {
        this.repository = repository;
    }

    public void loadPlayer(UUID uuid, String name) {
        repository.findById(uuid).thenAccept(opt -> {
            if (opt.isPresent()) {
                sessionCache.put(uuid, opt.get());

                if (!opt.get().getName().equals(name)) {
                    opt.get().setName(name);
                    savePlayer(opt.get());
                }
            } else {

                PlayerData newData = new PlayerData(uuid, name);
                sessionCache.put(uuid, newData);
                repository.save(newData);
            }
        }).exceptionally(e -> {
            e.printStackTrace();
            return null;
        });
    }

    public void unloadPlayer(UUID uuid) {
        PlayerData data = sessionCache.remove(uuid);
        if (data != null) {
            repository.save(data);
        }
    }

    public void savePlayer(PlayerData data) {
        repository.save(data);
    }

    public void saveAll() {
        sessionCache.values().forEach(this::savePlayer);
    }

    public PlayerData getPlayer(UUID uuid) {
        return sessionCache.get(uuid);
    }
}
