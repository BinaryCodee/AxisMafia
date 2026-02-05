package it.axis.mafia.api.domain.shared.value;

public class Currency {
    private final String identifier;
    private final String symbol;

    public Currency(String identifier, String symbol) {
        this.identifier = identifier;
        this.symbol = symbol;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getSymbol() {
        return symbol;
    }

    @Override
    public int hashCode() {
        return identifier.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Currency))
            return false;
        return identifier.equals(((Currency) o).identifier);
    }
}
