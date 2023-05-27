package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

public class CategoryScreen implements Screen {
    private Session session;
    private RouterService router;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    @Override
    public void start(Scanner scanner) {
        System.out.println("Welcome to the Category screen " + session.getUsername() + "!");
        scanner.nextLine();

        String input = " ";

        logger.info("Navigated to Category screen.");

        exit: {
            while (true) {
                clearScreen();
                // System.out.println("Welcome to the Minecraft Store!");
                System.out.println("\n[1] Redstone");
                System.out.println("[2] Potions");
                System.out.println("[3] Tools");
                System.out.println("[4] Weapons");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to Redstone screen.");
                        router.navigate("/redstone", scanner);
                        break;
                    case "2":
                        logger.info("Navigating to Potions screen.");
                        router.navigate("/potions", scanner);
                        break;
                    case "3":
                        logger.info("Navigating to Tools screen.");
                        router.navigate("/tools", scanner);
                        break;
                    case "4":
                        logger.info("Navigating to Wespons screen.");
                        router.navigate("/weapons", scanner);
                        break;
                    case "x":
                        logger.info("Exit home screen.");
                        System.out.println("\nGoodbye!");
                        break;
                    default:
                        logger.warn("Invalid option");
                        clearScreen();
                        System.out.println("Invalid option selected.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        break;
                }
            }
        }
    }

    /*
     * -------------------------------Helper Methods--------------------------------
     */

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
