package com.revature.p0.screens;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.revature.p0.models.User;
import com.revature.p0.services.RouterService;
import com.revature.p0.services.UserService;
import com.revature.p0.utils.Session;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginScreen implements Screen {
    private final UserService userService;
    private final RouterService routerService;
    private Session session;
    private static final Logger logger = LogManager.getLogger(RegisterScreen.class);

    @Override
    public void start(Scanner scanner) {
        String username = " ";
        String password = " ";

        logger.info("Start login process...");

        // loops until conditions are met
        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the login screen!");

                // get username
                username = getUsername(scanner);

                logger.info("username: {}", username);

                if (username.equals("x")) {
                    logger.info("Exit login screen");
                    break exit;
                }
                // get password
                password = getPassword(scanner);
                if (password.equals("x")) {
                    break exit;
                }
                User existingUser = userService.login(username, password);
                if (existingUser != null) {
                    session.setSession(existingUser);
                    routerService.navigate("/menu", scanner);
                } else {
                    clearScreen();
                    System.out.println("Invalid username or password.");
                    break exit;
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
            break;
        }
        return username;
    }

    // get the password of user
    public String getPassword(Scanner scanner) {
        String password = "";

        while (true) {
            System.out.println("\nEnter a password (x to cancel): ");
            password = scanner.nextLine();

            if (password.equalsIgnoreCase("x")) {
                return "x";
            }

            if (!userService.isValidPassword(password)) {
                clearScreen();
                System.out.println("Invalid password!.");
                System.out.print("\nPress enter to continue...");
                scanner.nextLine();
                continue;
            }
            return password;
        }
    }

    // method to clear the terminal
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
