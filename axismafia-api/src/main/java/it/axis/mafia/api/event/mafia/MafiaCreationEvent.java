package it.axis.mafia.api.event.mafia;

import it.axis.mafia.api.event.AxisMafiaEvent;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class MafiaCreationEvent extends AxisMafiaEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final String name;
    private final String color;
    private boolean cancelled;

    public MafiaCreationEvent(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.cancelled = b;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
