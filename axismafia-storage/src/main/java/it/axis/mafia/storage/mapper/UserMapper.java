package it.axis.mafia.storage.mapper;

import it.axis.mafia.api.dto.user.UserDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public UserDTO map(ResultSet rs) throws SQLException {
        UserDTO dto = new UserDTO();
        dto.setId(rs.getString("uuid"));
        dto.setName(rs.getString("name"));
        dto.setBalance(rs.getDouble("balance"));
        dto.setKills(rs.getInt("kills"));
        dto.setDeaths(rs.getInt("deaths"));
        return dto;
    }
}
