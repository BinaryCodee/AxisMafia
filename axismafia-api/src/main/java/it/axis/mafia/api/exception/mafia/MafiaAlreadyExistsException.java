package it.axis.mafia.api.exception.mafia;

import it.axis.mafia.api.exception.AxisMafiaException;

public class MafiaAlreadyExistsException extends AxisMafiaException {
    public MafiaAlreadyExistsException(String name) {
        super("Mafia already exists: " + name);
    }
}
