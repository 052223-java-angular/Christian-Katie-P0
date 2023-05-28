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
    private static final Logger logger = LogManager.getLogger(ProductScreen.class);

    /*
     * @param RedstoneProducts takes in a scanner object as a parameter then
     * displays a list
     * of redstone items from the database allowing the user to select one. The
     * category id is
     * hardcoded in. The first for loop iterates the products into name and price
     * lists. The
     * second for loop iterates the products into a numbered list format. The user
     * is then
     * prompted to choose an item.
     * 
     * This method of retrieving products can be expanded dynamically with an
     * infinante number
     * of categories. The method can be copied and all that needs to change is the
     * method name,
     * initial print statement, and category id. The method will print out every
     * item in the
     * category.
     * 
     * @author Katie Osborne
     */
    public void RedstoneProducts(Scanner scanner) {

        System.out.println("These are the redstone products:");
        String id = "b6a0aed8-fbfe-11ed-be56-0242ac120002";
        List<Product> products = productService.findAllByCategoryId(id);

        List<String> productNames = new ArrayList<>();
        List<Integer> productPrices = new ArrayList<>();

        for (Product product : products) {
            productNames.add(product.getName());
            productPrices.add(product.getPrice());
        }

        for (int i = 0; i < productNames.size(); i++) {
            System.out.println((i + 1) + ". " + productNames.get(i) + " - $" + productPrices.get(i));
        }

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

    /*
     * @param PotionProducts takes in a scanner object as a parameter then displays
     * a list
     * of potion items from the database allowing the user to select one. The
     * category id is
     * hardcoded in. The first for loop iterates the products into name and price
     * lists. The
     * second for loop iterates the products into a numbered list format. The user
     * is then
     * prompted to choose an item.
     * 
     * This method of retrieving products can be expanded dynamically with an
     * infinante number
     * of categories. The method can be copied and all that needs to change is the
     * method name,
     * initial print statement, and category id. The method will print out every
     * item in the
     * category.
     * 
     * @author Katie Osborne
     */
    public void PotionProducts(Scanner scanner) {
        System.out.println("These are the potion products:");
        String id = "b6a0awd8-fbfe-11ed-be56-0242ac120002";
        List<Product> products = productService.findAllByCategoryId(id);

        List<String> productNames = new ArrayList<>();
        List<Integer> productPrices = new ArrayList<>();

        for (Product product : products) {
            productNames.add(product.getName());
            productPrices.add(product.getPrice());
        }

        for (int i = 0; i < productNames.size(); i++) {
            System.out.println((i + 1) + ". " + productNames.get(i) + " - $" + productPrices.get(i));
        }

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

    /*
     * @param ToolProducts takes in a scanner object as a parameter then displays a
     * list
     * of tool items from the database allowing the user to select one. The category
     * id is
     * hardcoded in. The first for loop iterates the products into name and price
     * lists. The
     * second for loop iterates the products into a numbered list format. The user
     * is then
     * prompted to choose an item.
     * 
     * This method of retrieving products can be expanded dynamically with an
     * infinante number
     * of categories. The method can be copied and all that needs to change is the
     * method name,
     * initial print statement, and category id. The method will print out every
     * item in the
     * category.
     * 
     * @author Katie Osborne
     */
    public void ToolProducts(Scanner scanner) {
        System.out.println("These are the tool products:");
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

    /*
     * @param WeaponProducts takes in a scanner object as a parameter then displays
     * a list
     * of weapon items from the database allowing the user to select one. The
     * category id is
     * hardcoded in. The first for loop iterates the products into name and price
     * lists. The
     * second for loop iterates the products into a numbered list format. The user
     * is then
     * prompted to choose an item.
     * 
     * This method of retrieving products can be expanded dynamically with an
     * infinante number
     * of categories. The method can be copied and all that needs to change is the
     * method name,
     * initial print statement, and category id. The method will print out every
     * item in the
     * category.
     * 
     * @author Katie Osborne
     */
    public void WeaponProducts(Scanner scanner) {
        System.out.println("These are the weapon products:");
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