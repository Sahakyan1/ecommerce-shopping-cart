package com.shop.repository;
import com.shop.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {
        products.add(new Product(1, "Laptop", 999.99, 5));
        products.add(new Product(2, "Smartphone", 599.99, 10));
        products.add(new Product(3, "Headphones", 79.99, 15));
        products.add(new Product(4, "Wireless Mouse", 25.50, 3));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;    }}
