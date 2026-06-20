package com.shop.model;
import java.util.Objects;
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;
    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(id);  }

    @Override
    public String toString() {
        return name + " (Price: $" + price + ", Available Stock: " + stock + ")";
    }}
