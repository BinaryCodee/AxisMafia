package it.axis.mafia.api.model;

import it.axis.mafia.api.enums.MafiaRank;
import org.bukkit.Location;
import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class MafiaData {
    private final String name;
    private String color;
    private String baseLocation; // Serialized location
    private double totalXp;
    
    private Map<UUID, MafiaRank> members;
    private Map<String, Boolean> unlockedKits;

    public MafiaData(String name, String color) {
        this.name = name;
        this.color = color;
        this.totalXp = 0;
        this.members = new HashMap<>();
        this.unlockedKits = new HashMap<>();
    }

    public String getName() { return name; }
    
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    
    public String getBaseLocation() { return baseLocation; }
    public void setBaseLocation(String baseLocation) { this.baseLocation = baseLocation; }
    
    public double getTotalXp() { return totalXp; }
    public void setTotalXp(double totalXp) { this.totalXp = totalXp; }
    
    public Map<UUID, MafiaRank> getMembers() { return members; }
    public void setMembers(Map<UUID, MafiaRank> members) { this.members = members; }
    
    public Map<String, Boolean> getUnlockedKits() { return unlockedKits; }
    public void setUnlockedKits(Map<String, Boolean> unlockedKits) { this.unlockedKits = unlockedKits; }
}
