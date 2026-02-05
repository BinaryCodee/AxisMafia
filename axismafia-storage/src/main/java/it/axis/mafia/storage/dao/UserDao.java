package it.axis.mafia.storage.dao;

import it.axis.mafia.api.dto.user.UserDTO;
import java.util.Optional;

public interface UserDao {
    void create(UserDTO user);

    Optional<UserDTO> read(String id);

    void update(UserDTO user);

    void delete(String id);
}
