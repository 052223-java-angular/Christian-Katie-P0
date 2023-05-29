package com.revature.p0.screens;

import java.util.ArrayList;
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
    private static final Logger logger = LogManager.getLogger(ProductScreen.class);

    @Override
    public void start(Scanner scanner) {
        logger.info("User navigated to the Orders screen.");
        clearScreen();
        System.out.println("Here are your orders:");
        System.out.println("-ID-|-Date-|-Cost-");

        if (session.isLoggedIn()) {
            String username = session.getUsername();
            String id = session.getId();
            List<Order> orders = orderService.findAllByUsername(username);
            // List<OrderItems> orderItems = orderService.findAllByOrderItemsId(id);

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

    // while(true)

    // {
    // String choice = scanner.nextLine();
    // // char choiceTwo = scanner.next().charAt('x');
    // scanner.nextLine();

    // if (Integer.parseInt(choice) == 1) {
    // break;
    // } else if (Integer.parseInt(choice) == 2) {
    // System.out.println("Redfish");
    // break;
    // } else if (choice == "x") {
    // System.out.println("Exiting order details");
    // router.navigate("/order", scanner);
    // break;
    // } else {
    // System.out.println("Invalid selection, please try again.");
    // }
    // }

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
