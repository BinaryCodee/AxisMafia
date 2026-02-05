package it.axis.mafia.api.event;

import it.axis.mafia.api.model.MafiaData;
import it.axis.mafia.api.model.TerritoryData;
import it.axis.mafia.api.model.PlayerData;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class TerritoryConquerEvent extends AxisMafiaEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final TerritoryData territory;
    private final MafiaData attackerMafia;
    private final PlayerData conqueror;
    private boolean cancelled;

    public TerritoryConquerEvent(TerritoryData territory, MafiaData attackerMafia, PlayerData conqueror) {
        this.territory = territory;
        this.attackerMafia = attackerMafia;
        this.conqueror = conqueror;
    }

    public TerritoryData getTerritory() { return territory; }
    public MafiaData getAttackerMafia() { return attackerMafia; }
    public PlayerData getConqueror() { return conqueror; }

    @Override
    public boolean isCancelled() { return cancelled; }
    @Override
    public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    @Override
    public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
}
