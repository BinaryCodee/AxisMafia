package it.axis.mafia.storage.connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {
    private final HikariDataSource dataSource;

    public ConnectionFactory(File dataFolder) {
        if (!dataFolder.exists())
            dataFolder.mkdirs();
        File dbFile = new File(dataFolder, "axismafia.db");

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:sqlite:" + dbFile.getAbsolutePath());
        config.setPoolName("AxisMafia-Enterprise-Pool");
        config.setMaximumPoolSize(20); // Scaled up
        config.setConnectionTimeout(30000);

        this.dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void shutdown() {
        if (!dataSource.isClosed())
            dataSource.close();
    }
}
