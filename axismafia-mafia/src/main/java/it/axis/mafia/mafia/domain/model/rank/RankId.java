package it.axis.mafia.mafia.domain.model.rank;

import java.io.Serializable;

public class RankId implements Serializable {
    private final String id;

    public RankId(String id) {
        this.id = id;
    }

    public String getValue() {
        return id;
    }
}
