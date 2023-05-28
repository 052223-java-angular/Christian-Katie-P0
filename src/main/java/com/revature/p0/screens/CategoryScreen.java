package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.ProductService;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;
import com.revature.p0.screens.ProductScreen;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CategoryScreen implements Screen {
    ProductService productService;
    private RouterService router;
    private Session session;
    private static final Logger logger = LogManager.getLogger(HomeScreen.class);

    @Override
    public void start(Scanner scanner) {

        // System.out.println("Welcome to the Category screen " + session.getUsername()
        // + "!");
        // scanner.nextLine();

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
                ProductScreen productScreen = new ProductScreen(productService, router, session);

                switch (input.toLowerCase()) {
                    case "1":
                        logger.info("Navigating to Products screen.");
                        // router.navigate("/products/redstone", scanner);
                        productScreen.RedstoneProducts(scanner);
                        break;
                    case "2":
                        logger.info("Navigating to Products screen.");
                        router.navigate("/products/potions", scanner);
                        // productScreen.PotionProducts();
                        break;
                    case "3":
                        logger.info("Navigating to Products screen.");
                        router.navigate("/products/tools", scanner);
                        // productScreen.ToolProducts();
                        break;
                    case "4":
                        logger.info("Navigating to Products screen.");
                        router.navigate("/products/weapons", scanner);
                        // productScreen.WeaponProducts();
                        break;
                    case "x":
                        logger.info("Exit home screen.");
                        System.out.println("\nGoodbye!");
                        break exit;
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
