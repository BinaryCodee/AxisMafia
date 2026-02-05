package it.axis.mafia.api.event;

import it.axis.mafia.api.model.MafiaData;
import it.axis.mafia.api.model.PlayerData;
import it.axis.mafia.api.enums.MafiaRank;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

public class MafiaRankupEvent extends AxisMafiaEvent implements Cancellable {
    private static final HandlerList handlers = new HandlerList();
    private final PlayerData player;
    private final MafiaData mafia;
    private final MafiaRank oldRank;
    private final MafiaRank newRank;
    private boolean cancelled;

    public MafiaRankupEvent(PlayerData player, MafiaData mafia, MafiaRank oldRank, MafiaRank newRank) {
        this.player = player;
        this.mafia = mafia;
        this.oldRank = oldRank;
        this.newRank = newRank;
    }

    public PlayerData getPlayer() { return player; }
    public MafiaData getMafia() { return mafia; }
    public MafiaRank getOldRank() { return oldRank; }
    public MafiaRank getNewRank() { return newRank; }

    @Override
    public boolean isCancelled() { return cancelled; }
    @Override
    public void setCancelled(boolean cancel) { this.cancelled = cancel; }

    @Override
    public HandlerList getHandlers() { return handlers; }
    public static HandlerList getHandlerList() { return handlers; }
}
