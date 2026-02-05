package it.axis.mafia.api.service;

import it.axis.mafia.api.model.MafiaData;
import it.axis.mafia.api.model.PlayerData;
import it.axis.mafia.api.enums.MafiaRank;

public interface MafiaService {
    void createMafia(String name, String color, String baseLocation);
    void disbandMafia(String name);
    void addMember(String mafiaName, PlayerData player, MafiaRank rank);
    void removeMember(String mafiaName, PlayerData player);
    void promoteMember(String mafiaName, PlayerData player);
    void demoteMember(String mafiaName, PlayerData player);
    MafiaData getMafia(String name);
    MafiaData getPlayerMafia(PlayerData player);
}
