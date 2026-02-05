package it.axis.mafia.api.event.mafia;

import it.axis.mafia.api.event.AxisMafiaEvent;
import it.axis.mafia.api.domain.mafia.Mafia;
import org.bukkit.event.HandlerList;

public class MafiaDisbandEvent extends AxisMafiaEvent {
    private static final HandlerList handlers = new HandlerList();
    private final Mafia mafia;

    public MafiaDisbandEvent(Mafia mafia) {
        this.mafia = mafia;
    }

    public Mafia getMafia() {
        return mafia;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
