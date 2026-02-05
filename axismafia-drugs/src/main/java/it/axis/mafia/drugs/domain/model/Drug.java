package it.axis.mafia.drugs.domain.model;

public class Drug {
    private final String name;
    private final DrugPurity purity;
    private final double toxicity;

    public Drug(String name, int purityPercent) {
        this.name = name;
        this.purity = new DrugPurity(purityPercent);
        this.toxicity = (100 - purityPercent) * 0.5;
    }

    public DrugPurity getPurity() {
        return purity;
    }

    public double getToxicity() {
        return toxicity;
    }
}
