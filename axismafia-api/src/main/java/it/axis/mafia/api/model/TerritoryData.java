package it.axis.mafia.api.model;

import org.bukkit.Location;

public class TerritoryData {
    private final String name;
    private String ownerMafia;
    private String biome;
    private double revenuePerMinute;
    
    // Bounds (simplified for now, could be Min/Max coords)
    private String worldName;
    private int minX, minZ, maxX, maxZ;
    private double centerX, centerY, centerZ;

    public TerritoryData(String name, String biome, double revenuePerMinute) {
        this.name = name;
        this.biome = biome;
        this.revenuePerMinute = revenuePerMinute;
        this.ownerMafia = null;
    }

    public String getName() { return name; }
    
    public String getOwnerMafia() { return ownerMafia; }
    public void setOwnerMafia(String ownerMafia) { this.ownerMafia = ownerMafia; }
    
    public String getBiome() { return biome; }
    public void setBiome(String biome) { this.biome = biome; }
    
    public double getRevenuePerMinute() { return revenuePerMinute; }
    public void setRevenuePerMinute(double revenuePerMinute) { this.revenuePerMinute = revenuePerMinute; }
    
    public void setBounds(String worldName, int minX, int minZ, int maxX, int maxZ) {
        this.worldName = worldName;
        this.minX = minX;
        this.minZ = minZ;
        this.maxX = maxX;
        this.maxZ = maxZ;
    }
    
    public void setCenter(double x, double y, double z) {
        this.centerX = x;
        this.centerY = y;
        this.centerZ = z;
    }

    public String getWorldName() { return worldName; }
    public int getMinX() { return minX; }
    public int getMinZ() { return minZ; }
    public int getMaxX() { return maxX; }
    public int getMaxZ() { return maxZ; }
    public double getCenterX() { return centerX; }
    public double getCenterY() { return centerY; }
    public double getCenterZ() { return centerZ; }
}
