package com.revature.p0.screens;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuScreen implements Screen {
    private Session session;
    private final RouterService router;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    @Override
    public void start(Scanner scanner) {
        System.out.println("Welcome to the menu screen " + session.getUsername() + "!");
        scanner.nextLine();

        String input = " ";

        logger.info("Navigated to menu screen.");

        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the Minecraft Store!");
                System.out.println("\n[1] Shopping Cart");
                System.out.println("[2] Products");
                System.out.println("[3] Orders");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to Shopping Cart screen.");
                        router.navigate("/login", scanner);
                        break;
                    case "2":
                        logger.info("Navigating to Products screen.");
                        router.navigate("/register", scanner);
                        break;
                    case "3":
                        logger.info("Navigating to Orders screen.");
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
