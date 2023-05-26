package com.revature.p0.screens;

import java.util.Scanner;
import javax.management.relation.RoleNotFoundException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.models.User;
import com.revature.p0.services.RouterService;
import com.revature.p0.services.UserService;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterScreen implements Screen {
    private final UserService userService;
    private final RouterService routerService;
    private Session session;
    private static final Logger logger = LogManager.getLogger(RegisterScreen.class);

    @Override
    public void start(Scanner scanner) {
        String username = " ";
        String password = " ";

        logger.info("Start registration process...");

        // loops until conditions are met
        exit: {
            while (true) {
                clearScreen();
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
                        try {
                            User createdUser = userService.register(username, password);
                            session.setSession(createdUser);
                            routerService.navigate("/menu", scanner);
                            break exit;
                        } catch (RoleNotFoundException e) {
                            clearScreen();
                            System.out.println("An error has occured. Please try again. " +
                                    e.getMessage());
                            System.out.println("\nPress enter to continue...");
                            e.printStackTrace();
                            scanner.nextLine();
                        }
                    case "n":
                        logger.info("Restarting registration process...");
                        clearScreen();
                        System.out.println("Restarting process.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        break;
                    default:
                        logger.info("Invalit option!");
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

    // get the username of user
    public String getUsername(Scanner scanner) {
        String username = "";

        while (true) {
            System.out.print("\nEnter your username (x to cancel):");
            username = scanner.nextLine();

            if (username.equalsIgnoreCase("x")) {
                return "x";
            }

            if (!userService.isValidUsername(username)) {
                logger.warn("Invalid username for: {}", username);
                clearScreen();
                System.out.println("Username needs to be 8 to 20 characters long.");
                System.out.print("\nPress enter to continue...");
                scanner.nextLine();
                continue;
            }

            if (!userService.isUniqueUsername(username)) {
                logger.warn("Username is not unique for: {}", username);
                clearScreen();
                System.out.println("Username is not unique.");
                System.out.print("\nPress enter to continue...");
                scanner.nextLine();
                continue;
            }

            break;
        }

        return username;
    }

    // get the password of user
    public String getPassword(Scanner scanner) {
        String password = "";
        String confirm = "";

        while (true) {
            System.out.println("\nEnter a password (x to cancel): ");
            password = scanner.nextLine();

            if (password.equalsIgnoreCase("x")) {
                return "x";
            }

            if (!userService.isValidPassword(password)) {
                clearScreen();
                System.out.println("Password needs to be minumum of eight chartacter, at least 1 letter and 1 number.");
                System.out.print("\nPress enter to continue...");
                scanner.nextLine();
                continue;
            }

            System.out.println("\nPlease confirm password(x to cancel): ");
            confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("x")) {
                return "x";
            }

            if (!userService.isSamePassword(password, confirm)) {
                clearScreen();
                System.out.println("Passwords do not match.");
                System.out.print("\nPress enter to continue...");
                scanner.nextLine();
                continue;
            }

            break;
        }

        return password;
    }

    // method to clear the terminal
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}