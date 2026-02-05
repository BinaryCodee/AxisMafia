package it.axis.mafia.api.exception.user;

import it.axis.mafia.api.exception.AxisMafiaException;

public class UserNotFoundException extends AxisMafiaException {
    public UserNotFoundException(String id) {
        super("User not found: " + id);
    }
}
