package it.axis.mafia.api.domain.mafia.model;

public class MafiaBank extends AbstractMafiaAsset {
    private double balance;

    public MafiaBank(String id) {
        super(id);
        this.balance = 0;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double getBalance() {
        return balance;
    }
}
