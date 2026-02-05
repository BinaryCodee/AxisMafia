package it.axis.mafia.api.exception;

public abstract class AxisMafiaException extends RuntimeException {
    public AxisMafiaException(String message) {
        super(message);
    }

    public AxisMafiaException(String message, Throwable cause) {
        super(message, cause);
    }
}
