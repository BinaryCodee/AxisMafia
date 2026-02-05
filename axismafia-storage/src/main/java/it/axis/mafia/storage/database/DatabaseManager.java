package it.axis.mafia.storage.database;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;

public class DatabaseManager {

    private final HikariDataSource dataSource;

    public DatabaseManager(File dataFolder) {
        if (!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File dbFile = new File(dataFolder, "axismafia.db");
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:" + dbFile.getAbsolutePath());
        config.setPoolName("AxisMafia-SQLite");
        config.setMaximumPoolSize(10);
        config.setConnectionTimeout(30000);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        this.dataSource = new HikariDataSource(config);

        initializeTables();
    }

    public void close() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private void initializeTables() {

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS players (" +
                    "uuid VARCHAR(36) PRIMARY KEY, " +
                    "name VARCHAR(16), " +
                    "mafia_name VARCHAR(64), " +
                    "global_level INT, " +
                    "global_xp DOUBLE, " +
                    "kills INT, " +
                    "deaths INT, " +
                    "balance DOUBLE, " +
                    "reputation_type VARCHAR(32), " +
                    "reputation_points INT, " +
                    "robbery_count INT, " +
                    "last_robbery_time BIGINT, " +
                    "last_daily_reset BIGINT, " +
                    "economy_json TEXT, " +
                    "last_daily_pizzo BIGINT" +
                    ")");

            stmt.execute("CREATE TABLE IF NOT EXISTS mafias (" +
                    "name VARCHAR(64) PRIMARY KEY, " +
                    "color VARCHAR(16), " +
                    "base_location TEXT, " +
                    "total_xp DOUBLE, " +
                    "members_json TEXT, " +
                    "unlocked_kits_json TEXT" +
                    ")");

            stmt.execute("CREATE TABLE IF NOT EXISTS territories (" +
                    "name VARCHAR(64) PRIMARY KEY, " +
                    "owner_mafia VARCHAR(64), " +
                    "biome VARCHAR(32), " +
                    "revenue_per_min DOUBLE, " +
                    "world_name VARCHAR(32), " +
                    "min_x INT, min_z INT, max_x INT, max_z INT, " +
                    "center_x DOUBLE, center_y DOUBLE, center_z DOUBLE" +
                    ")");

            stmt.execute("CREATE TABLE IF NOT EXISTS horses (" +
                    "owner_uuid VARCHAR(36) PRIMARY KEY, " +
                    "mafia_name VARCHAR(64), " +
                    "speed DOUBLE, " +
                    "jump DOUBLE, " +
                    "health DOUBLE, " +
                    "experience DOUBLE, " +
                    "level INT" +
                    ")");

            stmt.execute("CREATE TABLE IF NOT EXISTS bounties (" +
                    "target_uuid VARCHAR(36) PRIMARY KEY, " +
                    "setter_uuid VARCHAR(36), " +
                    "amount DOUBLE, " +
                    "timestamp BIGINT" +
                    ")");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public CompletableFuture<Void> executeUpdate(String sql, Consumer<PreparedStatement> preparer) {
        return CompletableFuture.runAsync(() -> {
            try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                preparer.accept(ps);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public <T> CompletableFuture<T> executeQuery(String sql, Consumer<PreparedStatement> preparer,
            Function<java.sql.ResultSet, T> mapper) {
        return CompletableFuture.supplyAsync(() -> {
            try (Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
                preparer.accept(ps);
                try (java.sql.ResultSet rs = ps.executeQuery()) {
                    return mapper.apply(rs);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        });
    }
}
