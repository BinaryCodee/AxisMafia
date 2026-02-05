package it.axis.mafia.shop.domain.model;

import java.util.concurrent.atomic.AtomicInteger;

public class Stock {
    private final AtomicInteger quantity;
    private final boolean infinite;

    public Stock(int initial, boolean infinite) {
        this.quantity = new AtomicInteger(initial);
        this.infinite = infinite;
    }

    public boolean hasStock(int amount) {
        return infinite || quantity.get() >= amount;
    }

    public void reduce(int amount) {
        if (!infinite)
            quantity.addAndGet(-amount);
    }
}
