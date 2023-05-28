package com.revature.p0.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.models.Product;
import com.revature.p0.services.ProductService;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ProductScreen {
    private final ProductService productService;
    private final RouterService router;
    private final Session session;
    // private final String productType;
    private static final Logger logger = LogManager.getLogger(ProductScreen.class);

    // Retrieves redstone products from database
    public void RedstoneProducts(Scanner scanner) {

        System.out.println("These are the redstone products:");
        String id = "b6a0aed8-fbfe-11ed-be56-0242ac120002";
        List<Product> products = productService.findAllByCategoryId(id);

        List<String> productNames = new ArrayList<>();
        List<Integer> productPrices = new ArrayList<>();

        // Populate productNames and productPrices lists with values from products
        for (Product product : products) {
            productNames.add(product.getName());
            productPrices.add(product.getPrice());
        }

        for (int i = 0; i < productNames.size(); i++) {
            System.out.println((i + 1) + ". " + productNames.get(i) + " - $" + productPrices.get(i));
        }

        // user input for choice
        System.out.print("Choose a productNames item: ");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= productNames.size()) {
                System.out.println("You chose " + productNames.get(choice - 1));

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Retrieves potion products from database
    public void PotionProducts(Scanner scanner) {
        System.out.println("These are the redstone products:");
        String id = "b6a0awd8-fbfe-11ed-be56-0242ac120002";
        List<Product> products = productService.findAllByCategoryId(id);

        List<String> productNames = new ArrayList<>();
        List<Integer> productPrices = new ArrayList<>();

        // Populate productNames and productPrices lists with values from products
        for (Product product : products) {
            productNames.add(product.getName());
            productPrices.add(product.getPrice());
        }

        for (int i = 0; i < productNames.size(); i++) {
            System.out.println((i + 1) + ". " + productNames.get(i) + " - $" + productPrices.get(i));
        }

        // user input for choice
        System.out.print("Choose a productNames item: ");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= productNames.size()) {
                System.out.println("You chose " + productNames.get(choice - 1));

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Retrieves tool products from database
    public void ToolProducts(Scanner scanner) {
        System.out.println("These are the redstone products:");
        String id = "b6a0ard8-fbfe-11ed-be56-0242ac120002";
        List<Product> products = productService.findAllByCategoryId(id);

        List<String> productNames = new ArrayList<>();
        List<Integer> productPrices = new ArrayList<>();

        // Populate productNames and productPrices lists with values from products
        for (Product product : products) {
            productNames.add(product.getName());
            productPrices.add(product.getPrice());
        }

        for (int i = 0; i < productNames.size(); i++) {
            System.out.println((i + 1) + ". " + productNames.get(i) + " - $" + productPrices.get(i));
        }

        // user input for choice
        System.out.print("Choose a productNames item: ");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= productNames.size()) {
                System.out.println("You chose " + productNames.get(choice - 1));

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Retrieves weapon products from database
    public void WeaponProducts(Scanner scanner) {
        System.out.println("These are the redstone products:");
        String id = "b6a0agd8-fbfe-11ed-be56-0242ac120002";
        List<Product> products = productService.findAllByCategoryId(id);

        List<String> productNames = new ArrayList<>();
        List<Integer> productPrices = new ArrayList<>();

        // Populate productNames and productPrices lists with values from products
        for (Product product : products) {
            productNames.add(product.getName());
            productPrices.add(product.getPrice());
        }

        for (int i = 0; i < productNames.size(); i++) {
            System.out.println((i + 1) + ". " + productNames.get(i) + " - $" + productPrices.get(i));
        }

        // user input for choice
        System.out.print("Choose a productNames item: ");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice > 0 && choice <= productNames.size()) {
                System.out.println("You chose " + productNames.get(choice - 1));

            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}