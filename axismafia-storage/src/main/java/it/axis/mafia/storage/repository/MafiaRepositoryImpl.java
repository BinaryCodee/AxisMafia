package it.axis.mafia.storage.repository;

import it.axis.mafia.api.model.MafiaData;
import it.axis.mafia.api.repository.MafiaRepository;
import it.axis.mafia.storage.database.DatabaseManager;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class MafiaRepositoryImpl implements MafiaRepository {

    private final DatabaseManager db;
    private final Map<String, MafiaData> cache = new ConcurrentHashMap<>();

    public MafiaRepositoryImpl(DatabaseManager db) {
        this.db = db;
    }

    @Override
    public CompletableFuture<Void> save(MafiaData data) {
        cache(data);
        String sql = "INSERT OR REPLACE INTO mafias (name, color, base_location, total_xp) VALUES (?, ?, ?, ?)";
        return db.executeUpdate(sql, ps -> {
            try {
                ps.setString(1, data.getName());
                ps.setString(2, data.getColor());
                ps.setString(3, data.getBaseLocation());
                ps.setDouble(4, data.getTotalXp());

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public CompletableFuture<Optional<MafiaData>> findById(String id) {
        if (cache.containsKey(id)) {
            return CompletableFuture.completedFuture(Optional.of(cache.get(id)));
        }
        return db.executeQuery("SELECT * FROM mafias WHERE name = ?", ps -> {
            try {
                ps.setString(1, id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }, rs -> {
            try {
                if (rs.next()) {
                    MafiaData data = new MafiaData(rs.getString("name"), rs.getString("color"));
                    data.setBaseLocation(rs.getString("base_location"));
                    data.setTotalXp(rs.getDouble("total_xp"));
                    cache.put(id, data);
                    return Optional.of(data);
                }
                return Optional.empty();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public CompletableFuture<Set<MafiaData>> findAll() {
        return db.executeQuery("SELECT * FROM mafias", ps -> {
        }, rs -> {
            Set<MafiaData> set = new HashSet<>();
            try {
                while (rs.next()) {
                    MafiaData data = new MafiaData(rs.getString("name"), rs.getString("color"));
                    data.setBaseLocation(rs.getString("base_location"));
                    data.setTotalXp(rs.getDouble("total_xp"));
                    set.add(data);
                    cache.put(data.getName(), data);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return set;
        });
    }

    @Override
    public CompletableFuture<Void> delete(String id) {
        cache.remove(id);
        return db.executeUpdate("DELETE FROM mafias WHERE name = ?", ps -> {
            try {
                ps.setString(1, id);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public void cache(MafiaData value) {
        cache.put(value.getName(), value);
    }

    @Override
    public void invalidate(String id) {
        cache.remove(id);
    }
}
