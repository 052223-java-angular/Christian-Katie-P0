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

    // @Override
    // public void start(Scanner scanner) {
    // String[] armor = {"Helmet", "Chestplate", "Leggings", "Boots", "Shield",
    // "Elytra", "Turtle Shell"};

    // System.out.println("1. Helmet");
    // System.out.println("2. Chestplate");
    // System.out.println("3. Leggings");
    // System.out.println("4. Boots");
    // System.out.println("5. Shield");

    // // user input for choice
    // //Scanner scanner = new Scanner(System.in);
    // System.out.print("Choose a armor: ");
    // int choice = scanner.nextInt();

    // // print users choice
    // if (choice == 1) {
    // System.out.println("You chose Helmet");
    // } else if (choice == 2) {
    // System.out.println("You chose Chestplate");
    // } else if (choice == 3) {
    // System.out.println("You chose Leggings");
    // } else if (choice == 4) {
    // System.out.println("You chose Boots");
    // } else if (choice == 5) {
    // System.out.println("You chose Shield");
    // } else {
    // System.out.println("Invalid choice");
    // }
    // }
    // }
    // if ("redstone".equalsIgnoreCase(productType)) {
    // RedstoneProducts();
    // } else if ("potions".equalsIgnoreCase(productType)) {
    // PotionProducts();
    // } else if ("tools".equalsIgnoreCase(productType)) {
    // ToolProducts();
    // } else if ("weapons".equalsIgnoreCase(productType)) {
    // WeaponProducts();
    // }
    // }

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

        // System.out.println("productNames: " + productNames);
        // System.out.println("productPrices: " + productPrices);

        // products.forEach(product -> System.out.println(product.getName()));

        for (int i = 0; i < productNames.size(); i++) {
            System.out.println((i + 1) + ". " + productNames.get(i) + " - $" + productPrices.get(i));
        }

        // user input for choice
        // Scanner scanner = new Scanner(System.in);

        System.out.print("Choose a productNames item: ");
        int choice = scanner.nextInt();
        scanner.nextInt();

        // for loop to dynamically generate choice options
        boolean validChoice = false;
        for (int i = 0; i < productNames.size(); i++) {
            if (choice == i + 1) {
                System.out.println("You chose " + productNames.get(i));
                validChoice = true;
                scanner.nextInt();
                break;
            }
        }
        if (!validChoice) {
            System.out.println("Invalid choice");
        }
    }

    // [
    // Product{id='p1', name='Laptop', price=1000, categoryId='c1'},
    // Product{id='p2', name='Desktop', price=800, categoryId='c1'},
    // Product{id='p3', name='Monitor', price=200, categoryId='c1'}
    // ]

}

// public void PotionProducts() {
// System.out.println("These are the potions:");
// String id = "b6a0awd8-fbfe-11ed-be56-0242ac120002";
// List<Product> products = productService.findAllByCategoryId(id);
// products.forEach(product -> System.out.println(product.getName()));
// }

// public void ToolProducts() {
// System.out.println("These are the tools:");
// String id = "b6a0ard8-fbfe-11ed-be56-0242ac120002";
// List<Product> products = productService.findAllByCategoryId(id);
// products.forEach(product -> System.out.println(product.getName()));
// }

// public void WeaponProducts() {
// System.out.println("These are the weapons:");
// String id = "b6a0agd8-fbfe-11ed-be56-0242ac120002";
// List<Product> products = productService.findAllByCategoryId(id);
// products.forEach(product -> System.out.println(product.getName()));
// }

/*
 * call redstone method()
 * sout("Welcome to the redstone screen!)
 */

/*
 * call potion method()
 * sout("Welcome to the postion screen!")
 */

/*
 * call tools method()
 * sout("Welcome to the tools screen!")
 */

/*
 * call weapons method()
 * sout("Welcome to the weapons screen!")
 */

/*----------------Helper Methods------------------*/
/*
 * redstone method() {
 * [1] redstone
 * [2] repeaters
 * [3] dispensers
 * [4] hoppers
 * }
 */

/*
 * potions method() {
 * [1] water breathing
 * [2] night vision
 * [3] weakness
 * [4] health
 * }
 */

/*
 * tools method() {
 * [1] pickaxe
 * [2] axe
 * [3] hoe
 * [4] shovel
 * }
 */

/*
 * weapons method() {
 * [1] wooden sword
 * [2] stone sword
 * [3] iron sword
 * [4] diamond sword
 * }
 */

// @Override
// public void start(Scanner scanner) {
// System.out.println("Welcome to the Redstone screen " + session.getUsername()
// + "!");
// scanner.nextLine();

// String input = " ";

// logger.info("Navigated to Menu screen.");

// exit: {
// while (true) {
// clearScreen();
// // System.out.println("Welcome to the Minecraft Store!");
// System.out.println("\n[1] Redstone");
// System.out.println("[2] Repeaters");
// System.out.println("[3] Dispensers");
// System.out.println("[4] Hoppers");
// System.out.println("[x] Exit");

// System.out.println("\nEnter: ");
// input = scanner.nextLine();

// switch (input.toLowerCase()) {
// case "1":
// logger.info("Navigating to Redstone screen.");
// router.navigate("/redstone", scanner);
// break;
// case "2":
// logger.info("Navigating to Repeaters screen.");
// router.navigate("/repeaters", scanner);
// break;
// case "3":
// logger.info("Navigating to Dispenser screen.");
// router.navigate("/dispensers", scanner);
// break;
// case "4":
// logger.info("Navigating to Hopper screen.");
// router.navigate("/hoppers", scanner);
// break;
// case "x":
// logger.info("Exit home screen.");
// System.out.println("\nGoodbye!");
// break;
// default:
// logger.warn("Invalid option");
// clearScreen();
// System.out.println("Invalid option selected.");
// System.out.print("\nPress enter to continue...");
// scanner.nextLine();
// break;
// }
// }
// }
// }

// /*
// * -------------------------------Helper
// Methods--------------------------------
// */

// private void clearScreen() {
// System.out.print("\033[H\033[2J");
// System.out.flush();
// }
// }
