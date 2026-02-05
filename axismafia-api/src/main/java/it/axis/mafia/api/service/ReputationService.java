package it.axis.mafia.api.service;

import it.axis.mafia.api.model.PlayerData;
import it.axis.mafia.api.enums.ReputationType;

public interface ReputationService {
    void addReputation(PlayerData player, int points);
    void removeReputation(PlayerData player, int points);
    void setReputation(PlayerData player, ReputationType type);
    void updateReputationType(PlayerData player); // Recalculates type based on points
}
