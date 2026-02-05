package it.axis.mafia.api.event.user;

import it.axis.mafia.api.event.AxisMafiaEvent;
import it.axis.mafia.api.domain.user.User;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class UserPreLoadEvent extends AxisMafiaEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final String userId;
    private boolean cancelled;

    public UserPreLoadEvent(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
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
