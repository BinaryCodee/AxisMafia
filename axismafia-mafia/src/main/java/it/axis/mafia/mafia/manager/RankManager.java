package it.axis.mafia.mafia.manager;

import it.axis.mafia.api.enums.MafiaRank;

public class RankManager {
    // Handles rank logic, requirements, etc.
    // For now simple placeholder logic

    public boolean canPromote(MafiaRank current) {
        return current.getNext() != null;
    }
}
