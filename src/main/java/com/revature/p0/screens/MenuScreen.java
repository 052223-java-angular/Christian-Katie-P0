package com.revature.p0.screens;

import java.util.Scanner;

import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MenuScreen implements IScreen {
    private Session session;

    @Override
    public void start(Scanner scanner) {
        System.out.println("Welcome to the menu screen " + session.getUsername() + "!");
        scanner.nextLine();

    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
