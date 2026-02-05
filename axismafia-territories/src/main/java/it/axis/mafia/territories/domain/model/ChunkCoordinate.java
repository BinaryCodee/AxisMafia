package it.axis.mafia.territories.domain.model;

public class ChunkCoordinate {
    private final int x;
    private final int z;
    private final String world;

    public ChunkCoordinate(String world, int x, int z) {
        this.world = world;
        this.x = x;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public String getWorld() {
        return world;
    }
}
