package it.axis.mafia.gui.domain.model;

import java.util.HashMap;
import java.util.Map;

public class Menu {
    private final MenuTitle title;
    private final MenuSize size;
    private final Map<Integer, Button> buttons;

    public Menu(MenuTitle title, MenuSize size) {
        this.title = title;
        this.size = size;
        this.buttons = new HashMap<>();
    }

    public void setButton(int slot, Button button) {
        buttons.put(slot, button);
    }
}
