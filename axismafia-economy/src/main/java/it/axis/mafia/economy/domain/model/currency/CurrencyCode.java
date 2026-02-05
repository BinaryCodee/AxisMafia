package it.axis.mafia.economy.domain.model.currency;

public class CurrencyCode {
    private final String code;

    public CurrencyCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return code;
    }
}
