package com.revature.p0.screens;

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
    // private Session session;
    // private RouterService router;
    private ProductService productService;
    // private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    public static void RedstoneProducts() {
        System.out.println("There are the redstone products:");

        // productService = findAllByCategoryId("b6a0aed8-fbfe-11ed-be56-0242ac120002");

    }

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
}
