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
     * It has been given functionality to display Category menu options. Line 53
     * instantiates
     * a new productScreen object that routes the user to the category they picked.
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
                ProductScreen productScreen = new ProductScreen(reviewService, productService, router, session);

                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to products/redstone screen.");
                        productScreen.RedstoneProducts(scanner);
                        break;
                    case "2":
                        logger.info("Navigating to products/postions screen.");
                        productScreen.PotionProducts(scanner);
                        break;
                    case "3":
                        logger.info("Navigating to products/tools screen.");
                        productScreen.ToolProducts(scanner);
                        break;
                    case "4":
                        logger.info("Navigating to proucts/weapons screen.");
                        productScreen.WeaponProducts(scanner);
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
