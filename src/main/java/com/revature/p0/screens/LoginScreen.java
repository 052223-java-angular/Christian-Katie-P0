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

    /*
     * @param start() is an abstract method implemented from the Screen interface.
     * It has been given functionality to display LoginScreen menu options which
     * allow the user to Login or Exit. The username and password are retrieved,
     * and if they match an existing user, then login was successful and the user
     * is routed to the MenuScreen through the RouterService. Exit ends the program.
     * 
     * @author Katie Osborne
     */
    @Override
    public void start(Scanner scanner) {
        String username = " ";
        String password = " ";

        logger.info("Start login process...");

        // loops until conditions are met
        exit: {
            while (true) {
                clearScreen();
                System.out.println("Please Login!");

                // get username
                logger.info("username: {}", username);
                username = getUsername(scanner);

                if (username.equals("x")) {
                    logger.info("Exit login screen");
                    break exit;
                }
                // get password
                password = getPassword(scanner);
                if (password.equals("x")) {
                    break exit;
                }
                // if username and password are correct, route to menu
                User existingUser = userService.login(username, password);
                if (existingUser != null) {
                    session.setSession(existingUser);
                    routerService.navigate("/menu", scanner);
                    break exit;
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

    /*
     * @param getUsername takes in scanner and checks the username
     * to see if it's valid through the userService which connects to the UserDAO.
     * As long as the username is valid, the username is returned.
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
                // continue;
            }
            break;
        }
        return username;
    }

    /*
     * @param getPassword takes in scanner and checks the password
     * to see if it's valid through the userService which connects to the UserDAO.
     * As long as the password is valid, the password is returned.
     * 
     * @author Katie Osborne
     */
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
                System.out.println("Invalid password!");
                System.out.print("\nPress enter to continue...");
                scanner.nextLine();
                // continue;
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
