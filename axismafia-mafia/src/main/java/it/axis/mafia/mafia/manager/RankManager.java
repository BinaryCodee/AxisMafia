package it.axis.mafia.mafia.manager;

import it.axis.mafia.api.enums.MafiaRank;

public class RankManager {

    public boolean canPromote(MafiaRank current) {
        return current.getNext() != null;
    }
}
