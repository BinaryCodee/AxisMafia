package it.axis.mafia.territories.domain.model;

import java.util.Optional;

public class TerritoryOwner {
    private final String mafiaId;

    public TerritoryOwner(String mafiaId) {
        this.mafiaId = mafiaId;
    }

    public Optional<String> getMafiaId() {
        return Optional.ofNullable(mafiaId);
    }

    public boolean isCaptured() {
        return mafiaId != null;
    }
}
