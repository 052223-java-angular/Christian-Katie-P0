package com.revature.p0.screens;

import java.util.Scanner;

public class RegisterScreen implements iScreen {

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
                scanner.nextLine();

                // get username
                username = getUsername(scanner);

                // get password

                // get email

                // confirm user info

                // break when info is correct
                break exit;
            }
        }
    }

    /*
     * -------------------------------Helper Methods--------------------------------
     */

    // get the username of user
    public String getUsername(Scanner scanner) {
        System.out.print("\nEnter your username:");
        String username = scanner.nextLine();
        System.out.println("Username: " + username);

        clearScreen();
        return " ";
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
