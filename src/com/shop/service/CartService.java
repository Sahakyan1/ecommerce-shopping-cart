package com.shop.service;
import com.shop.exception.InsufficientStockException;
import com.shop.model.Product;
import java.util.HashMap;
import java.util.Map;

public class CartService {
    private Map<Product, Integer> cart = new HashMap<>();

    public void addProductToCart(Product product, int quantity) throws InsufficientStockException {
        if (product == null) {
            return;
        }
        int currentInCart = cart.getOrDefault(product, 0);
        int totalRequested = currentInCart + quantity;

        if (totalRequested > product.getStock()) {
            throw new InsufficientStockException("Sorry, only " + product.getStock() + " units of " + product.getName() + " are available.");
        }

        cart.put(product, totalRequested);}
    public Map<Product, Integer> getCartItems() {
        return cart;
    }

    public double calculateTotal() {
        double total = 0;
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public void checkout() {
        for (Map.Entry<Product, Integer> entry : cart.entrySet()) {
            Product product = entry.getKey();
            int purchasedQuantity = entry.getValue();
            product.setStock(product.getStock() - purchasedQuantity); 
        }
        cart.clear();   }}
