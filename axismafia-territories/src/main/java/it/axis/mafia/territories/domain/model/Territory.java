package it.axis.mafia.territories.domain.model;

public class Territory {
    private final TerritoryId id;
    private final TerritoryName name;
    private final ChunkCoordinate center;
    private TerritoryOwner owner;
    private TerritoryRevenue revenue;

    public Territory(TerritoryId id, TerritoryName name, ChunkCoordinate center) {
        this.id = id;
        this.name = name;
        this.center = center;
        this.owner = new TerritoryOwner(null);
        this.revenue = new TerritoryRevenue(0.0);
    }

    public void capture(String mafiaId) {
        this.owner = new TerritoryOwner(mafiaId);
    }

    public void liberate() {
        this.owner = new TerritoryOwner(null);
    }

    public TerritoryId getId() {
        return id;
    }

    public TerritoryOwner getOwner() {
        return owner;
    }
}
