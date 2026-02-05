package it.axis.mafia.mafia.infrastructure.mapper;

import it.axis.mafia.api.dto.mafia.MafiaDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MafiaDataMapper {
    public MafiaDTO mapFromResultSet(ResultSet rs) throws SQLException {
        MafiaDTO dto = new MafiaDTO();
        dto.setName(rs.getString("name"));
        dto.setColor(rs.getString("color"));
        dto.setBaseLocation(rs.getString("base_location"));
        return dto;
    }
}
