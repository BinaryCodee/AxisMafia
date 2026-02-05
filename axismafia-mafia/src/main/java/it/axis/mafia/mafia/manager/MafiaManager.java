package it.axis.mafia.mafia.manager;

import it.axis.mafia.api.model.MafiaData;importit.axis.mafia.api.repository.MafiaRepository;
import it.axis.mafia.core.manager.AbstractManager;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class MafiaManager extends AbstractManager {
    private final MafiaRepository repository;
    private final Map<String, MafiaData> cache = new ConcurrentHashMap<>();

    public MafiaManager(JavaPlugin plugin, MafiaRepository repository) {
        super(plugin);
        this.repository = repository;
    }

    @Override
    public void onEnable() {
        repository.findAll().thenAccept(mafias -> {
            for (MafiaData m : mafias) {
                cache.put(m.getName().toLowerCase(), m);
            }
            log("Loaded " + mafias.size() + " mafias.");
        });
    }

    @Override
    public void onDisable() {
        cache.values().forEach(repository::save);
    }

    public MafiaData getMafia(String name) {
        return cache.get(name.toLowerCase());
    }

    public void createMafia(String name, String color) {
        if (cache.containsKey(name.toLowerCase()))
            return;

        MafiaData mafia = new MafiaData(name, color, null);
        cache.put(name.toLowerCase(), mafia);
        repository.save(mafia);
    }

    public void disbandMafia(String name) {
        cache.remove(name.toLowerCase());
        repository.delete(name);
    }
}
