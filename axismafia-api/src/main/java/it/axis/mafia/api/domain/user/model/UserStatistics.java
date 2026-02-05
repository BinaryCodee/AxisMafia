package it.axis.mafia.api.domain.user.model;

public interface UserStatistics {
    int getKills();

    int getDeaths();

    double getKdr();

    void incrementKills();

    void incrementDeaths();

    long getPlayTimeMillis();
}
