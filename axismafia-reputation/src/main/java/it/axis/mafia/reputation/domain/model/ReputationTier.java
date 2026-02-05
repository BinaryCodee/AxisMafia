package it.axis.mafia.reputation.domain.model;

public enum ReputationTier {
    LEGENDARY(1000),
    RESPECTED(500),
    NEUTRAL(0),
    SUSPICIOUS(-100),
    WANTED(-500);

    private final int threshold;

    ReputationTier(int threshold) {
        this.threshold = threshold;
    }

    public static ReputationTier fromPoints(ReputationPoints points) {
        int val = points.getValue();
        for (ReputationTier tier : values()) {
            if (val >= tier.threshold)
                return tier;
        }
        return WANTED; // Default lowest if not captured by ordered iteration logic
    }
}
