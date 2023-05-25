package com.revature.p0.screens;

import java.util.Scanner;

import com.revature.p0.services.RouterService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HomeScreen implements iScreen {
    private final RouterService router;

    @Override
    public void start(Scanner scanner) {
        String input = " ";

        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the store!");
                System.out.println("\n[1] Login");
                System.out.println("[2] Register");
                System.out.println("[x] Exit");

                System.out.println("\nEnter: ");
                input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case "1":
                        break;
                    case "2":
                        router.navigate("/register", scanner);
                        break;
                    case "x":
                        System.out.println("Goodbye!");
                        break exit;
                    default:
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

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
