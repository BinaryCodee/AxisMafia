package it.axis.mafia.storage.repository;

import it.axis.mafia.api.model.TerritoryData;
import it.axis.mafia.api.repository.TerritoryRepository;
import it.axis.mafia.storage.database.DatabaseManager;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

public class TerritoryRepositoryImpl implements TerritoryRepository {

    private final DatabaseManager db;
    private final Map<String, TerritoryData> cache = new ConcurrentHashMap<>();

    public TerritoryRepositoryImpl(DatabaseManager db) {
        this.db = db;
    }

    @Override
    public CompletableFuture<Void> save(TerritoryData data) {
        cache(data);
        String sql = "INSERT OR REPLACE INTO territories (name, owner_mafia, biome, revenue_per_min, world_name, min_x, min_z, max_x, max_z, center_x, center_y, center_z) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        return db.executeUpdate(sql, ps -> {
            try {
                ps.setString(1, data.getName());
                ps.setString(2, data.getOwnerMafia());
                ps.setString(3, data.getBiome());
                ps.setDouble(4, data.getRevenuePerMinute());
                ps.setString(5, data.getWorldName());
                ps.setInt(6, data.getMinX());
                ps.setInt(7, data.getMinZ());
                ps.setInt(8, data.getMaxX());
                ps.setInt(9, data.getMaxZ());
                ps.setDouble(10, data.getCenterX());
                ps.setDouble(11, data.getCenterY());
                ps.setDouble(12, data.getCenterZ());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    @Override
    public CompletableFuture<Optional<TerritoryData>> findById(String id) {
        if (cache.containsKey(id))
            return CompletableFuture.completedFuture(Optional.of(cache.get(id)));
        return db.executeQuery("SELECT * FROM territories WHERE name = ?", ps -> {
            try {
                ps.setString(1, id);
            } catch (SQLException e) {
            }
        }, rs -> {
            try {
                if (rs.next()) {
                    TerritoryData data = new TerritoryData(rs.getString("name"), rs.getString("biome"),
                            rs.getDouble("revenue_per_min"));
                    data.setOwnerMafia(rs.getString("owner_mafia"));
                    data.setBounds(rs.getString("world_name"), rs.getInt("min_x"), rs.getInt("min_z"),
                            rs.getInt("max_x"), rs.getInt("max_z"));
                    data.setCenter(rs.getDouble("center_x"), rs.getDouble("center_y"), rs.getDouble("center_z"));
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
    public CompletableFuture<Set<TerritoryData>> findAll() {
        return db.executeQuery("SELECT * FROM territories", ps -> {
        }, rs -> {
            Set<TerritoryData> set = new HashSet<>();
            try {
                while (rs.next()) {
                    TerritoryData data = new TerritoryData(rs.getString("name"), rs.getString("biome"),
                            rs.getDouble("revenue_per_min"));
                    data.setOwnerMafia(rs.getString("owner_mafia"));
                    data.setBounds(rs.getString("world_name"), rs.getInt("min_x"), rs.getInt("min_z"),
                            rs.getInt("max_x"), rs.getInt("max_z"));
                    data.setCenter(rs.getDouble("center_x"), rs.getDouble("center_y"), rs.getDouble("center_z"));
                    set.add(data);
                    cache.put(data.getName(), data);
                }
            } catch (SQLException e) {
            }
            return set;
        });
    }

    @Override
    public CompletableFuture<Void> delete(String id) {
        cache.remove(id);
        return db.executeUpdate("DELETE FROM territories WHERE name = ?", ps -> {
            try {
                ps.setString(1, id);
            } catch (SQLException e) {
            }
        });
    }

    @Override
    public void cache(TerritoryData value) {
        cache.put(value.getName(), value);
    }

    @Override
    public void invalidate(String id) {
        cache.remove(id);
    }
}
