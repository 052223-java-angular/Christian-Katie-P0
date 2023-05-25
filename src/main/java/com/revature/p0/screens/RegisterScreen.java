package com.revature.p0.screens;

import java.util.Scanner;

import com.revature.p0.models.Session;
import com.revature.p0.models.User;
import com.revature.p0.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterScreen implements IScreen {
    private final UserService userService;

    @Override
    public void start(Scanner scanner) {
        String input = " ";
        String username = " ";
        String password = " ";
        String email = " ";

        // loops until conditions are met
        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the register screen");

                // get username
                username = getUsername(scanner);
                if (username.equals("x")) {
                    break exit;
                }

                // get password
                password = getPassword(scanner);
                if (password.equals("x")) {
                    break exit;
                }

                // get email
                email = getEmail(scanner);
                if (email.equals("x")) {
                    break exit;
                }

                // confirm user info
                clearScreen();
                System.out.println("Please confirm your information:");
                System.out.println("\nUsername: " + username);
                System.out.println("Password: " + password);
                System.out.println("Emails: " + email);
                System.out.println("\nEnter (y/n): ");

                switch (scanner.nextLine()) {
                    case "y":
                        User createdUser = userService.register(username, password);
                        Session session = new Session();
                        session.setSession(createdUser);
                        router.navigate("/menu", scanner);
                        break exit;
                    case "n":
                        clearScreen();
                        System.out.println("Restarting process.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        break;
                    default:
                        clearScreen();
                        System.out.println("Invalid option selected.");
                        System.out.print("\nPress enter to continue...");
                        scanner.nextLine();
                        break;
                }

                // break when info is correct
                break exit; // will be removed
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
                clearScreen();
                System.out.println("Username needs to be 8 to 20 characters long.");
                System.out.print("\nPress enter to continue...");
                scanner.nextLine();
                continue;
            }

            if (!userService.isUniqueUsername(username)) {
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

    // get the email of user
    public String getEmail(Scanner scanner) {
        String email = "";

        while (true) {
            System.out.print("\nEnter your email (x to cancel):");
            email = scanner.nextLine();

            if (email.equalsIgnoreCase("x")) {
                return "x";
            }

            // if (!userService.isSameEmail(email)) {
            // clearScreen();
            // System.out.println("There is already an account with this email.");
            // System.out.print("\nPress enter to continue...");
            // scanner.nextLine();
            // continue;
            // }

            break;
        }
        return email;
    }

    // method to clear the terminal
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}