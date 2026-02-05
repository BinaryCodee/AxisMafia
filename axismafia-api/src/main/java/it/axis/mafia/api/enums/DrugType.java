package it.axis.mafia.api.enums;

public enum DrugType {
    MARIJUANA("Marijuana", "&a"),
    COCAINA("Cocaina", "&f"),
    EROINA("Eroina", "&8"),
    METANFETAMINA("Metanfetamina", "&b"),
    LSD("LSD", "&d");

    private final String displayName;
    private final String color;

    DrugType(String displayName, String color) {
        this.displayName = displayName;
        this.color = color;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getColor() {
        return color;
    }
}
