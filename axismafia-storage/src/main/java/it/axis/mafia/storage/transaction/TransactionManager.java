package it.axis.mafia.storage.transaction;

import it.axis.mafia.storage.connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Consumer;

public class TransactionManager {
    private final ConnectionFactory factory;

    public TransactionManager(ConnectionFactory factory) {
        this.factory = factory;
    }

    public void runInTransaction(Consumer<Connection> operation) {
        try (Connection conn = factory.getConnection()) {
            boolean autoCommit = conn.getAutoCommit();
            conn.setAutoCommit(false);
            try {
                operation.accept(conn);
                conn.commit();
            } catch (Exception e) {
                conn.rollback();
                throw new RuntimeException("Transaction failed", e);
            } finally {
                conn.setAutoCommit(autoCommit);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Connection error", e);
        }
    }
}
