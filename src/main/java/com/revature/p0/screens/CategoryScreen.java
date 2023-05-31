package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.ProductService;
import com.revature.p0.services.ReviewService;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryScreen implements Screen {
    ReviewService reviewService;
    ProductService productService;
    private RouterService router;
    private Session session;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    /*
     * @param start() is an abstract method implemented from the Screen interface.
     * It has been given functionality to display Category menu options. The four
     * categories all route through the RouterService to four different methods
     * on the product screen.
     * 
     * @author Katie Osborne
     */

    @Override
    public void start(Scanner scanner) {
        String input = " ";

        logger.info("Navigated to Category screen.");

        exit: {
            while (true) {
                clearScreen();
                System.out.println("Please select a category: ");
                System.out.println("\n[1] Redstone");
                System.out.println("[2] Potions");
                System.out.println("[3] Tools");
                System.out.println("[4] Weapons");
                System.out.println("[x] Exit");
                System.out.println("\nEnter: ");
                input = scanner.nextLine();

                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to products/redstone screen.");
                        router.navigate("/product/redstone", scanner);
                        break;
                    case "2":
                        logger.info("Navigating to products/postions screen.");
                        router.navigate("/product/potion", scanner);
                        break;
                    case "3":
                        logger.info("Navigating to products/tools screen.");
                        router.navigate("/product/tool", scanner);
                        break;
                    case "4":
                        logger.info("Navigating to products/weapons screen.");
                        router.navigate("/product/weapon", scanner);
                        break;
                    case "x":
                        logger.info("Exit menu screen.");
                        router.navigate("/menu", scanner);
                        break;
                    default:
                        logger.warn("Invalid option");
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
