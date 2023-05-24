package com.revature.p0.screens;

import java.util.Scanner;

public class RegisterScreen implements iScreen {

    @Override
    public void start(Scanner scan) {
        String input = " ";
        exit: {
            while (true) {
                clearScreen();
                System.out.println("Welcome to the register screen");
                scan.nextLine();
                break exit;
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
