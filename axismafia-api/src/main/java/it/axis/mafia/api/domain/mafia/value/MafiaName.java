package it.axis.mafia.api.domain.mafia.value;

import java.io.Serializable;

public class MafiaName implements Serializable {
    private final String name;

    public MafiaName(String name) {
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
