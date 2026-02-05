package it.axis.mafia.api.domain.mafia.value;

import java.io.Serializable;

public class MafiaId implements Serializable {
    private final String id;

    public MafiaId(String id) {
        this.id = id;
    }

    public String getValue() {
        return id;
    }
}
