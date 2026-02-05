package it.axis.mafia.storage.dao;

import it.axis.mafia.api.dto.user.UserDTO;
import it.axis.mafia.storage.connection.ConnectionFactory;
import it.axis.mafia.storage.mapper.UserMapper;
import it.axis.mafia.storage.query.SelectQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class SqliteUserDao implements UserDao {
    private final ConnectionFactory connectionFactory;
    private final UserMapper mapper;

    public SqliteUserDao(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
        this.mapper = new UserMapper();
    }

    @Override
    public void create(UserDTO user) {
        String sql = "INSERT INTO players (uuid, name, balance, kills, deaths) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getId());
            ps.setString(2, user.getName());
            ps.setDouble(3, user.getBalance());
            ps.setInt(4, user.getKills());
            ps.setInt(5, user.getDeaths());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<UserDTO> read(String id) {
        SelectQuery query = new SelectQuery("players").where("uuid = ?");
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(query.getSql())) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapper.map(rs));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void update(UserDTO user) {
        String sql = "UPDATE players SET name=?, balance=?, kills=?, deaths=? WHERE uuid=?";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setDouble(2, user.getBalance());
            ps.setInt(3, user.getKills());
            ps.setInt(4, user.getDeaths());
            ps.setString(5, user.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM players WHERE uuid=?";
        try (Connection conn = connectionFactory.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
