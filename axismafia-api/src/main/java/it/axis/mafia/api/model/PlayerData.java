package it.axis.mafia.api.model;

import it.axis.mafia.api.enums.ReputationType;
import org.bukkit.Location;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class PlayerData {
    private final UUID uuid;
    private String name;
    private String mafiaName;
    private int globalLevel;
    private double globalXp;

    private int kills;
    private int deaths;

    private EconomyData economyData;
    private ReputationData reputationData;

    private long lastRobberyTime;
    private int dailyRobberyCount;
    private long lastDailyReset;

    public PlayerData(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
        this.mafiaName = null;
        this.globalLevel = 1;
        this.globalXp = 0;
        this.kills = 0;
        this.deaths = 0;
        this.economyData = new EconomyData();
        this.reputationData = new ReputationData();
        this.dailyRobberyCount = 0;
        this.lastDailyReset = System.currentTimeMillis();
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMafiaName() {
        return mafiaName;
    }

    public void setMafiaName(String mafiaName) {
        this.mafiaName = mafiaName;
    }

    public int getGlobalLevel() {
        return globalLevel;
    }

    public void setGlobalLevel(int globalLevel) {
        this.globalLevel = globalLevel;
    }

    public double getGlobalXp() {
        return globalXp;
    }

    public void setGlobalXp(double globalXp) {
        this.globalXp = globalXp;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public double getKdr() {
        return deaths == 0 ? kills : (double) kills / deaths;
    }

    public EconomyData getEconomyData() {
        return economyData;
    }

    public void setEconomyData(EconomyData economyData) {
        this.economyData = economyData;
    }

    public ReputationData getReputationData() {
        return reputationData;
    }

    public void setReputationData(ReputationData reputationData) {
        this.reputationData = reputationData;
    }

    public long getLastRobberyTime() {
        return lastRobberyTime;
    }

    public void setLastRobberyTime(long lastRobberyTime) {
        this.lastRobberyTime = lastRobberyTime;
    }

    public int getDailyRobberyCount() {
        return dailyRobberyCount;
    }

    public void setDailyRobberyCount(int dailyRobberyCount) {
        this.dailyRobberyCount = dailyRobberyCount;
    }

    public long getLastDailyReset() {
        return lastDailyReset;
    }

    public void setLastDailyReset(long lastDailyReset) {
        this.lastDailyReset = lastDailyReset;
    }
}
