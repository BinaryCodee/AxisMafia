package it.axis.mafia.api.domain.mafia.model;

public abstract class AbstractMafiaAsset {
    private final String assetId;

    public AbstractMafiaAsset(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetId() {
        return assetId;
    }
}
