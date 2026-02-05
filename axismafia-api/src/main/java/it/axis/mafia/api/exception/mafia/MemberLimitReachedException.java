package it.axis.mafia.api.exception.mafia;

import it.axis.mafia.api.exception.AxisMafiaException;

public class MemberLimitReachedException extends AxisMafiaException {
    public MemberLimitReachedException(int limit) {
        super("Member limit reached: " + limit);
    }
}
