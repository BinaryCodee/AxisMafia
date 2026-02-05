package it.axis.mafia.shop.domain.model;

public class Product {
    private final String name;
    private final Price price;
    private final Stock stock;

    public Product(String name, Price price, Stock stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Price getPrice() {
        return price;
    }

    public Stock getStock() {
        return stock;
    }
}
