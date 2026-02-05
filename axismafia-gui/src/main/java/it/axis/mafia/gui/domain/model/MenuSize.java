package it.axis.mafia.gui.domain.model;

public class MenuSize {
    private final int rows;

    public MenuSize(int rows) {
        if (rows < 1 || rows > 6)
            throw new IllegalArgumentException("Rows 1-6");
        this.rows = rows;
    }

    public int getSlots() {
        return rows * 9;
    }
}
