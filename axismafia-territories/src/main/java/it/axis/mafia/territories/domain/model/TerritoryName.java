package it.axis.mafia.territories.domain.model;

public class TerritoryName {
    private final String name;

    public TerritoryName(String name) {
        if (name == null)
            throw new IllegalArgumentException("Name null");
        this.name = name;
    }

    public String getValue() {
        return name;
    }
}
