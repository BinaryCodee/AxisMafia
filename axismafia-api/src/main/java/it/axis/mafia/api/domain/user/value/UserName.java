package it.axis.mafia.api.domain.user.value;

import java.io.Serializable;

public class UserName implements Serializable {
    private final String value;

    public UserName(String value) {
        if (value == null || value.isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
