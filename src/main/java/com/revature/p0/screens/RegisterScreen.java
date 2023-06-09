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
public class RegisterScreen implements Screen {
    private final UserService userService;
    private final RouterService routerService;
    private Session session;
    private static final Logger logger = LogManager.getLogger(RegisterScreen.class);

    /*
     * @param start() is an abstract method implemented from the Screen interface.
     * It has been given functionality to display RegisterScreen menu options which
     * allow the user to Register or Exit. The user is propted to enter a username,
     * password, confirm password, and upon confirmation, the username and password
     * are stored in the local database. Then the user is routed to the LoginScreen
     * through the RouterService. Exit ends the program.
     * 
     * @author Katie Osborne
     */
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
                        User createdUser = userService.register(username, password);
                        session.setSession(createdUser);
                        routerService.navigate("/login", scanner);
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

    /*
     * -------------------------------Helper Methods--------------------------------
     */

    /*
     * @param getUsername takes in scanner and checks the username
     * to see if it's valid and unique through the userService which
     * connects to the UserDAO. .
     * 
     * @return username if the username is valid and unique.
     * 
     * @author Katie Osborne
     */
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

    /*
     * @param getPassword takes in scanner and checks the password
     * to see if it's valid and checks if the user entered it correctly
     * the first time. This is done through the userService which
     * connects to the UserDAO.
     * 
     * @return password if the password is valid and entered correctly.
     * 
     * @author Katie Osborne
     */
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

    /*
     * @param ClearScreen is a method that clears the terminal.
     * It will be implemented should and invalid option be picked.
     * 
     * @author Katie Osborne
     */
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}