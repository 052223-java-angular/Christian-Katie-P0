package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.RouterService;
import com.revature.p0.services.UserService;
import com.revature.p0.utils.Session;

public class LoginScreen implements Screen {
    private final UserService userService;
    private final RouterService routerService;
    private Session session;
    private static final Logger logger = LogManager.getLogger(RegisterScreen.class);

    @Override
    public void start(Scanner scanner) {

        logger.info("Reached Login screen...");

        // option for Orders

        // option for Products

        // option for ShoppingCart

        exit: {
            while (true) {
                clearScreen();
                // greeting
                System.out.println("Welcome to the register screen!");

                // get username
                username = getUsername(scanner);

                logger.info("username: {}", username);

                if (username.equals("x")) {
                    logger.info("Exit registration screen");
                    break exit;
                }

                // get password
                password = getPassword(scanner);
                if (password.equals("x")) {
                    break exit;
                }

                // confirm user info
                clearScreen();
                System.out.println("Please confirm your information:");
                System.out.println("\nUsername: " + username);
                System.out.println("Password: " + password);
                System.out.println("\nEnter (y/n): ");

                switch (scanner.nextLine()) {
                    case "y":
                        logger.info("User confirmed credentials are correct.");
                        User createdUser = userService.register(username, password);
                        session.setSession(createdUser);
                        routerService.navigate("/menu", scanner);
                        break exit;
                    case "n":
                        logger.info("Restarting registration process...");
                        clearScreen();
                        System.out.println("Restarting process.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        break;
                    default:
                        logger.info("Invalid option!");
                        clearScreen();
                        System.out.println("Invalid option selected.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        break;
                }
            }
        }
    }

    // method to clear the terminal
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}