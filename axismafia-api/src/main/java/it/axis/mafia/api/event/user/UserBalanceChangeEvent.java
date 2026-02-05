package it.axis.mafia.api.event.user;

import it.axis.mafia.api.event.AxisMafiaEvent;
import it.axis.mafia.api.domain.user.User;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class UserBalanceChangeEvent extends AxisMafiaEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final User user;
    private double oldBalance;
    private double newBalance;
    private boolean cancelled;

    public UserBalanceChangeEvent(User user, double oldBalance, double newBalance) {
        this.user = user;
        this.oldBalance = oldBalance;
        this.newBalance = newBalance;
    }

    public User getUser() {
        return user;
    }

    public double getOldBalance() {
        return oldBalance;
    }

    public double getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(double newBalance) {
        this.newBalance = newBalance;
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
