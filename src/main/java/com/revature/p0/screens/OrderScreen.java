package com.revature.p0.screens;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.models.Order;
import com.revature.p0.models.User;
import com.revature.p0.services.OrderService;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderScreen implements Screen {
    private OrderService orderService;
    private final RouterService router;
    private final Session session;
    private static final Logger logger = LogManager.getLogger(ProductScreen.class);

    @Override
    public void start(Scanner scanner) {
        System.out.println("Here are your orders:");
        System.out.println("-ID-|-Date-|-Cost-");

        if (session.isLoggedIn()) {
            String username = session.getUsername();
            List<Order> orders = orderService.findAllByUsername(username);

            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                System.out.println(
                        (i + 1) + ". " + order.getId() + "|" + order.getCreatedAt() + "|$" + order.getTotalCost());
            }

            System.out.println("Select an order or enter '0' to exit:");
            while (true) {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice > 0 && choice <= orders.size()) {
                    // User has selected a valid order
                    Order selectedOrder = orders.get(choice - 1);

                    // Call orderDetails function for the selected order
                    orderDetails(scanner, selectedOrder);

                } else if (choice == 0) {
                    System.out.println("Exiting order selection");
                    break;
                } else {
                    System.out.println("Invalid selection, please try again.");
                }
            }

        } else {
            System.out.println("Please login to review your order.");
            router.navigate("/login", scanner);
        }
    }

    private void orderDetails(Scanner scanner, Order selectedOrder) {
        System.out.println("Selected Order:");
        System.out.println("Order ID: " + selectedOrder.getId());
        System.out.println("Order Date: " + selectedOrder.getCreatedAt());
        System.out.println("Total Cost: $" + selectedOrder.getTotalCost());
        System.out.println("---------------------------");
        System.out.println("Options:");
        System.out.println("1. Return to previous orders");
        System.out.println("2. Print \"Redfish\"");
        System.out.println("Choose an option or enter '0' to exit:");

        while (true) {
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                break;
            } else if (choice == 2) {
                System.out.println("Redfish");
                break;
            } else if (choice == 0) {
                System.out.println("Exiting order details");
                break;
            } else {
                System.out.println("Invalid selection, please try again.");
            }
        }
    }

    // @Override
    // public void start(Scanner scanner) {
    // // String input = " ";

    // logger.info("Navigated to the order screen.");

    // // clearScreen();
    // System.out.println("Here are your orders:");

    // // User getUserId = orderService.findAllByUserId(id);

    // // if (session.isLoggedIn()) {
    // // session.setSession(orders);
    // // productNames.add(product.getName());

    // String username = "Revature1";

    // System.out.println(orderService.findAllByUsername(username));

    // String id = findAllByUsername(username);
    // orderService = OrderService.getOrderService();

    // List<Order> orders = orderService.findAllByUserId(id);

    // List<String> orderCreatedAt = new ArrayList<>();
    // List<Integer> orderTotalCost = new ArrayList<>();

    // // Populate productNames and productPrices lists with values from products
    // for (Order order : orders) {
    // orderCreatedAt.add(order.getCreatedAt());
    // orderTotalCost.add(order.getTotalCost());
    // }

    // for (int i = 0; i < orderCreatedAt.size(); i++) {
    // System.out.println((i + 1) + ". " + orderCreatedAt.get(i) + " - $" +
    // orderTotalCost.get(i));
    // }
    // // User chooses product

    // System.out.print("Please select an item: ");

    // while (true) {
    // int choice = scanner.nextInt();
    // scanner.nextLine();

    // if (choice > 0 && choice <= orderCreatedAt.size())
    // ;
    // }

    // }
    // } else {
    // System.out.println("Please login to review your order.");
    // router.navigate("/login", scanner);
    // }
    // }
    /*--------------------------------Helper Method-----------------------------*/

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
