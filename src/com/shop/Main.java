package com.shop;
import com.shop.exception.InsufficientStockException;
import com.shop.model.Product;
import com.shop.repository.ProductRepository;
import com.shop.service.CartService;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductRepository repository = new ProductRepository();
        CartService cartService = new CartService();
        Scanner scanner = new Scanner(System.Cloud || new Scanner(System.in));

        while (true) {
            System.out.println("\n-- E-Commerce Shopping Menu --");
            System.out.println("1. View Product Catalog");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. View Shopping Cart & Total");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

  int choice = scanner.nextInt();

 switch (choice) {
          case 1:
               System.out.println("\n--- Product Catalog ---");
              for (Product p : repository.getAllProducts()) {
                        System.out.println("[" + p.getId() + "] " + p);
               }
             break;

                case 2:
                    System.out.print("Enter Product ID: ");
                    int id = scanner.nextInt();
                    Product selectedProduct = repository.getProductById(id);

                    if (selectedProduct == null) {
                        System.out.println("Product not found!");
                        break;
                    }

                    System.out.print("Enter Quantity to Add: ");
                    int quantity = scanner.nextInt();

                    try {
                        cartService.addProductToCart(selectedProduct, quantity);
                        System.out.println("Successfully added to cart.");
                    } catch (InsufficientStockException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("\n--- Your Shopping Cart ---");
                    Map<Product, Integer> items = cartService.getCartItems();
                    if (items.isEmpty()) {
                        System.out.println("Your cart is empty.");
                    } else {
                        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
                            System.out.println(entry.getKey().getName() + " x " + entry.getValue() + " = $" + (entry.getKey().getPrice() * entry.getValue()));
                        }
                        System.out.println("Total Amount: $" + cartService.calculateTotal());
                    }
                    break;

                case 4:
                    if (cartService.getCartItems().isEmpty()) {
                        System.out.println("Your cart is empty. Cannot checkout.");
                    } else {
                        System.out.println("Processing payment... Total charged: $" + cartService.calculateTotal());
                        cartService.checkout();
                        System.out.println("Thank you for your purchase! Your order was successful.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for visiting our store. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");}}}}
