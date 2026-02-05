package it.axis.mafia.api.enums;

public enum MafiaRank {
    RECLUTA(1, "Recluta", "&7"),
    PICCIOTTO(2, "Picciotto", "&a"),
    SOLDATO(3, "Soldato", "&e"),
    CAPORALE(4, "Caporale", "&6"),
    SERGENTE(5, "Sergente", "&c"),
    TENENTE(6, "Tenente", "&4"),
    CAPITANO(7, "Capitano", "&b"),
    CONSIGLIERE(8, "Consigliere", "&d"),
    VICE_BOSS(9, "Vice Boss", "&5"),
    PADRINO(10, "Padrino", "&4&l");

    private final int level;
    private final String displayName;
    private final String color;

    MafiaRank(int level, String displayName, String color) {
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

    public MafiaRank getNext() {
        if (this == PADRINO) return null;
        return values()[this.ordinal() + 1];
    }
}
