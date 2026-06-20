# E-Commerce Shopping Cart System

A console-based E-Commerce Shopping Cart application built with Java Core, demonstrating advanced usage of Java Collections, robust business logic validation, and clean object-oriented architecture.

This project simulates a real-world online store experience, focusing on inventory management, dynamic shopping cart operations, and automated checkout calculations.

##  Key Features

- Product Catalog Management: Browse available products with specific IDs, names, categories, and prices.
- Dynamic Shopping Cart: Add products to the cart, update item quantities, or remove items seamlessly.
- Real-Time Stock Validation: Prevents users from adding more items to the cart than what is currently available in the store's inventory.
- Automated Checkout:Calculates the subtotal, applies a simulated tax/discount, and generates a detailed order receipt.

##  Architecture & Design Principles

The project strictly follows the Separation of Concerns (SoC) principle, structuring the codebase into distinct layers:

1. Model Layer (`com.shop.model`): Contains domain models like `Product` and `CartItem` encapsulation rules.
2. Repository Layer (`com.shop.repository`):Manages the in-memory simulation of the store inventory.
3. Service Layer (`com.shop.service`): Handles core business logic, including stock availability checks and price calculations.
4. Exception Layer (`com.shop.exception`): Implements custom runtime exceptions such as `InsufficientStockException`.
5. UI Layer (`com.shop`):Features an interactive command-line interface via `Main.java` for simulated user workflows.


##  Technical Highlights & OOP Concepts

- Advanced Collections Framework:Utilized a `Map<Product, Integer>` inside the shopping cart to map a unique product directly to its selected quantity, preventing duplicate entries and allowing $O(1)$ complexity updates.
- Custom Exception Handling: Created domain-specific exceptions to handle edge cases like out-of-stock scenarios gracefully without crashing the application.
- Encapsulation & Data Integrity: Used strict access modifiers (`private` fields with public API methods) to prevent illegal modifications to product prices or inventory levels from outside the service layer.

## Prerequisites & How to Run

### Prerequisites
- Java Development Kit (JDK):Version 8 or higher.

### Running via Terminal

1. Clone the repository:
```bash
git clone [https://github.com/Sahakyan1/ecommerce-shopping-cart.git](https://github.com/Sahakyan1/ecommerce-shopping-cart.git)
cd ecommerce-shopping-cart/src
javac com/shop/Main.java
java com.shop.Main
