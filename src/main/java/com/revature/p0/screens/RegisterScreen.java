package com.revature.p0.screens;

import java.util.Scanner;

import com.revature.p0.services.UserService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterScreen implements iScreen {
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

                // get email

                // confirm user info

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
        return " ";
    }

    // get the email of user
    public String getEmail(Scanner scanner) {
        return " ";
    }

    // method to clear the terminal-purely *asthetic*
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}