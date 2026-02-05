package it.axis.mafia.api.exception.user;

import it.axis.mafia.api.exception.AxisMafiaException;

public class InsufficientBalanceException extends AxisMafiaException {
    public InsufficientBalanceException(double current, double required) {
        super(String.format("Insufficient balance. Has: %f, Required: %f", current, required));
    }
}
