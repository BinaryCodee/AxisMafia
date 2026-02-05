package it.axis.mafia.api.event.user;

import it.axis.mafia.api.event.AxisMafiaEvent;
import it.axis.mafia.api.domain.user.User;
import org.bukkit.event.HandlerList;

public class UserLoadEvent extends AxisMafiaEvent {
    private static final HandlerList handlers = new HandlerList();
    private final User user;

    public UserLoadEvent(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
