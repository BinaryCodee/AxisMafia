package it.axis.mafia.api.enums;

public enum ReputationType {
    NEMICO_PUBBLICO(1, "Nemico Pubblico", "&4"),
    CRIMINALE(2, "Criminale", "&c"),
    BULLO(3, "Bullo", "&6"),
    DISONESTO(4, "Disonesto", "&e"),
    NEUTRALE(5, "Neutrale", "&7"),
    ONESTO(6, "Onesto", "&a"),
    RISPETTABILE(7, "Rispettabile", "&2"),
    ONOREVOLE(8, "Onorevole", "&b"),
    EROE(9, "Eroe", "&3"),
    SANTO(10, "Santo", "&f&l");

    private final int level;
    private final String displayName;
    private final String color;

    ReputationType(int level, String displayName, String color) {
        this.level = level;
        this.displayName = displayName;
        this.color = color;
    }

    public int getLevel() {
        return level;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getColor() {
        return color;
    }
}
