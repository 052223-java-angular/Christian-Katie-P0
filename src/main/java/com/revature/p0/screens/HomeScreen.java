package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.RouterService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HomeScreen implements Screen {
    private final RouterService router;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    @Override
    public void start(Scanner scanner) {
        String input = " ";

        logger.info("Navigated to home screen.");

        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the Minecraft Store!");
                System.out.println("\n[1] Login");
                System.out.println("[2] Register");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to login screen.");
                        break;
                    case "2":
                        logger.info("Navigating to register screen.");
                        router.navigate("/register", scanner);
                        break;
                    case "x":
                        logger.info("Exit home screen.");
                        System.out.println("\nGoodbye!");
                        break exit;
                    default:
                        logger.warn("Invalid option");
                        clearScreen();
                        System.out.println("Invalid option selected.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        break;
                }//

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
