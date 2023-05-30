package com.revature.p0.screens;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuScreen implements Screen {
    private final RouterService router;
    private Session session;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    /*
     * @param start() is an abstract method implemented from the Screen interface.
     * It has been given functionality to display MenuScreen options which allow
     * the user to view their Shopping Cart, Categories, or Options. Shopping Cart,
     * Category, and Orders are routed through RouterService their respective
     * screen. Exit ends the program.
     * 
     * @author Katie Osborne
     */
    @Override
    public void start(Scanner scanner) {
        String input = " ";

        logger.info("Navigated to Menu screen.");

        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the Minecraft Store!");
                System.out.println("\n[1] Shopping Cart");
                System.out.println("[2] Categories");
                System.out.println("[3] Orders");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                input = scanner.nextLine();
                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to Shopping Cart screen.");
                        router.navigate("/shoppingCart", scanner);
                        break;
                    case "2":
                        logger.info("Navigating to Categories screen.");
                        router.navigate("/category", scanner);
                        break;
                    case "3":
                        logger.info("Navigating to Orders screen.");
                        router.navigate("/order", scanner);
                        break;
                    case "x":
                        logger.info("Exit home screen.");
                        // System.out.println("\nGoodbye!");
                        router.navigate("/home", scanner);
                        break;
                    default:
                        logger.warn("Invalid option");
                        clearScreen();
                        System.out.println("Invalid option selected.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        // scanner.close();
                        break;
                }
            }

        }
    }

    /*
     * -------------------------------Helper Methods--------------------------------
     */

    /*
     * @param getPassword takes in scanner, or user input, and checks the password
     * to see if it's valid through the userService which connects to the UserDAO.
     * As long as the password is valid, the password is returned.
     * 
     * @author Katie Osborne
     */
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
