package com.revature.p0.screens;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.models.Order;
import com.revature.p0.models.OrderItems;
import com.revature.p0.services.OrderService;
import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OrderScreen implements Screen {
    private OrderService orderService;
    private final RouterService router;
    private final Session session;
    private static final Logger logger = LogManager.getLogger(OrderScreen.class);

    /*
     * @param start() is an abstract method implemented from the Screen interface.
     * It has been given functionality to display OrderScreen options which allow
     * the user to view their Orders when they are logged in to their account.
     * 
     * First, it checks to see if the user is logged in. If not they are routed back
     * to the login screen. Next the username is called from the session to get all
     * the associated orders that belong to that username. Then those orders are
     * iterated through and displayed by their id, date, and total. The user can
     * then select an order to view more details and select 'x' at anytime to go
     * back.
     * 
     * @return a list of orders the users has made displaying the id, date, and
     * total.
     * 
     * @author Katie Osborne
     */
    @Override
    public void start(Scanner scanner) {
        logger.info("User navigated to the Orders screen.");
        clearScreen();
        System.out.println("Here are your orders:");
        System.out.println("-ID-|-Date-|-Total-");

        if (session.isLoggedIn()) {
            String username = session.getUsername();
            // String id = session.getId();
            List<Order> orders = orderService.findAllByUsername(username);

            for (int i = 0; i < orders.size(); i++) {
                Order order = orders.get(i);
                System.out.println(
                        (i + 1) + ". " + order.getId() + "|" + order.getCreatedAt() + "|$" + order.getTotalCost());
            }
            logger.info("User is selecting an order...");
            System.out.println("Select an order or enter 'x' to go back:");
            while (true) {
                String choice = scanner.nextLine();

                if (choice.equals("x")) {
                    logger.info("Navigating back to Menu screen.");
                    System.out.println("Exiting order selection");
                    router.navigate("/menu", scanner);
                    break;
                } else {
                    try {
                        int choiceInt = Integer.parseInt(choice);

                        if (choiceInt > 0 && choiceInt <= orders.size()) {
                            // User has selected a valid order
                            Order selectedOrder = orders.get(choiceInt - 1);
                            // OrderItems selectOrderItems = orderItems.get(choiceInt - 1);

                            // Call orderItems() method for the selected order
                            orderItems(scanner, selectedOrder);
                            // String print = "2A2B";
                            // System.out.println(orderService.findAllByOrderItemsId(print));

                        } else {
                            logger.info("Invalid option!");
                            System.out.println("Invalid selection, please try again.");
                            break;
                        }

                    } catch (NumberFormatException e) {
                        logger.info("Invalid input!");
                        System.out.println("Invalid input, please try again.");
                    }
                }
            }
        } else {
            System.out.println("Please login to review your order.");
            router.navigate("/login", scanner);
        }
    }
    /*
     * @param orderItems() is a method that allows the user to see the items they
     * purchased in a given order.
     * 
     * @return a list of order items from the selected order through the service
     * and iterated through. Then the order items are displayed by product name,
     * item quantity, item price, and product id.
     * 
     * @author Katie Osborne
     */

    private void orderItems(Scanner scanner, Order selectedOrder) {
        clearScreen();
        System.out.println("Selected Order:");
        System.out.println("Order ID: " + selectedOrder.getId());
        // Retrieve the list of order items for the selected order
        List<OrderItems> orderItem = orderService.findAllByOrderItemId(selectedOrder.getId());

        System.out.println("---------------------------");
        System.out.println("No. | Product Name | Quantity | Price | Product ID");
        System.out.println("---------------------------");

        for (int i = 0; i < orderItem.size(); i++) {
            OrderItems item = orderItem.get(i);
            String productName = orderService.findProductNameById(item.getProductId());
            System.out.println((i + 1) + "   | " + productName + " | " + item.getQuantity() + "        | $"
                    + item.getPrice() + " | " + item.getProductId());
        }

        System.out.println("---------------------------");
        System.out.println("Enter 'x' to go back:");

        while (true) {
            String choice = scanner.nextLine();

            if (choice.equals("x")) {
                router.navigate("/order", scanner);
                break;
            } else {
                logger.info("Invalid option!");
                System.out.println("Invalid selection, please try again.");
                break;
            }
        }
    }
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
