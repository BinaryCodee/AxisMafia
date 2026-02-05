package it.axis.mafia.territories.application.port.in;

public class ConquerTerritoryCommand {
    public final String territoryName;
    public final String attackerMafiaId;
    public final String attackerPlayerId;

    public ConquerTerritoryCommand(String territoryName, String attackerMafiaId, String attackerPlayerId) {
        this.territoryName = territoryName;
        this.attackerMafiaId = attackerMafiaId;
        this.attackerPlayerId = attackerPlayerId;
    }
}
