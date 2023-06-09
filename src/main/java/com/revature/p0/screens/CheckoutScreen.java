package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.CheckoutService;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckoutScreen implements Screen {
    private final CheckoutService checkoutService;
    private final RouterService router;
    private Session session;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    @Override
    public void start(Scanner scanner) {
        String input = " ";

        logger.info("Navigated to the Checkout screen.");

        exit: {
            while (true) {
                clearScreen();
                System.out.println("Are you ready to checkout?");
                System.out.println("\nEnter (y/n) ");

                switch (input = scanner.nextLine().toLowerCase()) {
                    case "y":
                        logger.info("User is checking out.");
                        // router.navigate("/category", scanner);
                        // checkoutService.findAllByShoppingCartId(getId());
                        break;
                    case "n":
                        logger.info("Navigating to ShoppingCart screen.");
                        router.navigate("/shoppingCart", scanner);
                        break;
                    case "x":
                        logger.info("Exit to exit screen.");
                        // System.out.println("\nGoodbye!");
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
