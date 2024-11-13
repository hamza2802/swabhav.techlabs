package com.techlabs.test;

import java.util.Scanner;

import com.techlabs.model.DataHandler;
import com.techlabs.model.Inventory;
import com.techlabs.model.Product;
import com.techlabs.model.Supplier;
import com.techlabs.model.Transaction;

public class InventoryTest {
    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);
    private static final String filepath = "C:\\Users\\hamza.ansari\\Desktop\\swabhav training\\inventorymanagment_app\\src\\Data";

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    productManagement();
                    break;
                case 2:
                    supplierManagement();
                    break;
                case 3:
                    transactionManagement();
                    break;
                case 4:
                    saveData();
                    break;
                case 5:
                    loadData();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Welcome to the Inventory Management System");
        System.out.println("1. Product Management");
        System.out.println("2. Supplier Management");
        System.out.println("3. Transaction Management");
        System.out.println("4. Save Data");
        System.out.println("5. Load Data");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void productManagement() {
        while (true) {
            System.out.println("Product Management");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View Product Details");
            System.out.println("5. View All Products");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    viewProductDetails();
                    break;
                case 5:
                    viewAllProducts();
                    break;
                case 6:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addProduct() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        Product product = new Product(id, name, quantity, price);
        inventory.addProduct(product);
        System.out.println("Product added successfully.");
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        String id = scanner.nextLine();
        Product product = findProductById(id);
        if (product != null) {
            System.out.print("Enter new product name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Enter new price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); 

            product.setName(name);
            product.setQuantity(quantity);
            product.setPrice(price);
            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void deleteProduct() {
        System.out.print("Enter product ID to delete: ");
        String id = scanner.nextLine();
        inventory.removeProduct(id);
        System.out.println("Product deleted successfully.");
    }

    private static void viewProductDetails() {
        System.out.print("Enter product ID: ");
        String id = scanner.nextLine();
        Product product = findProductById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewAllProducts() {
        System.out.println("All Products:");
        for (Product product : inventory.getProducts()) {
            System.out.println(product);
        }
    }

    private static Product findProductById(String id) {
        return inventory.getProducts().stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private static void supplierManagement() {
        while (true) {
            System.out.println("Supplier Management");
            System.out.println("1. Add Supplier");
            System.out.println("2. Update Supplier");
            System.out.println("3. Delete Supplier");
            System.out.println("4. View Supplier Details");
            System.out.println("5. View All Suppliers");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addSupplier();
                    break;
                case 2:
                    updateSupplier();
                    break;
                case 3:
                    deleteSupplier();
                    break;
                case 4:
                    viewSupplierDetails();
                    break;
                case 5:
                    viewAllSuppliers();
                    break;
                case 6:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSupplier() {
        System.out.print("Enter supplier ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter supplier name: ");
        String name = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();

        Supplier supplier = new Supplier(id, name, contactInfo);
        inventory.addSupplier(supplier);
        System.out.println("Supplier added successfully.");
    }

    private static void updateSupplier() {
        System.out.print("Enter supplier ID to update: ");
        String id = scanner.nextLine();
        Supplier supplier = findSupplierById(id);
        if (supplier != null) {
            System.out.print("Enter new supplier name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new contact info: ");
            String contactInfo = scanner.nextLine();

            supplier.setName(name);
            supplier.setContactInfo(contactInfo);
            System.out.println("Supplier updated successfully.");
        } else {
            System.out.println("Supplier not found.");
        }
    }

    private static void deleteSupplier() {
        System.out.print("Enter supplier ID to delete: ");
        String id = scanner.nextLine();
        inventory.removeSupplier(id);
        System.out.println("Supplier deleted successfully.");
    }

    private static void viewSupplierDetails() {
        System.out.print("Enter supplier ID: ");
        String id = scanner.nextLine();
        Supplier supplier = findSupplierById(id);
        if (supplier != null) {
            System.out.println(supplier);
        } else {
            System.out.println("Supplier not found.");
        }
    }

    private static void viewAllSuppliers() {
        System.out.println("All Suppliers:");
        for (Supplier supplier : inventory.getSuppliers()) {
            System.out.println(supplier);
        }
    }

    private static Supplier findSupplierById(String id) {
        return inventory.getSuppliers().stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private static void transactionManagement() {
        while (true) {
            System.out.println("Transaction Management");
            System.out.println("1. Add Stock");
            System.out.println("2. Remove Stock");
            System.out.println("3. View Transaction History");
            System.out.println("4. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStock();
                    break;
                case 2:
                    removeStock();
                    break;
                case 3:
                    viewTransactionHistory();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStock() {
        System.out.print("Enter product ID to add stock: ");
        String id = scanner.nextLine();
        System.out.print("Enter quantity to add: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 
        
        Product product = findProductById(id);
        if (product != null) {
            product.setQuantity(product.getQuantity() + quantity);
            inventory.addTransaction(new Transaction(id, quantity, new java.util.Date(), "ADD"));
            System.out.println("Stock added successfully.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void removeStock() {
        System.out.print("Enter product ID to remove stock: ");
        String id = scanner.nextLine();
        System.out.print("Enter quantity to remove: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); 

        Product product = findProductById(id);
        if (product != null) {
            if (product.getQuantity() >= quantity) {
                product.setQuantity(product.getQuantity() - quantity);
                inventory.addTransaction(new Transaction(id, quantity, new java.util.Date(), "REMOVE"));
                System.out.println("Stock removed successfully.");
            } else {
                System.out.println("Not enough stock available.");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewTransactionHistory() {
        System.out.println("Transaction History:");
        for (Transaction transaction : inventory.getTransactions()) {
            System.out.println(transaction);
        }
    }

    private static void saveData() {
        DataHandler.saveData(inventory, filepath);
        System.out.println("Data saved successfully.");
    }

    private static void loadData() {
        Inventory loadedInventory = DataHandler.loadData(filepath);
        if (loadedInventory != null) {
            inventory = loadedInventory;
            System.out.println("Data loaded successfully.");
        } else {
            System.out.println("Failed to load data.");
        }
    }
}
