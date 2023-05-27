package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

public class RedstoneScreen implements Screen {
    private Session session;
    private RouterService router;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    @Override
    public void start(Scanner scanner) {
        System.out.println("Welcome to the Redstone screen " + session.getUsername() + "!");
        scanner.nextLine();

        String input = " ";

        logger.info("Navigated to Menu screen.");

        exit: {
            while (true) {
                clearScreen();
                // System.out.println("Welcome to the Minecraft Store!");
                System.out.println("\n[1] Redstone");
                System.out.println("[2] Repeaters");
                System.out.println("[3] Dispensers");
                System.out.println("[4] Hoppers");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to Redstone screen.");
                        router.navigate("/redstone", scanner);
                        break;
                    case "2":
                        logger.info("Navigating to Repeaters screen.");
                        router.navigate("/repeaters", scanner);
                        break;
                    case "3":
                        logger.info("Navigating to Dispenser screen.");
                        router.navigate("/dispensers", scanner);
                        break;
                    case "4":
                        logger.info("Navigating to Hopper screen.");
                        router.navigate("/hoppers", scanner);
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
