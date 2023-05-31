package com.revature.p0;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

// The main class for P0Project
public class p0 {
  private static final Logger logger = LogManager.getLogger(p0.class);

  /*
   * @param Entry point of the application. Upon starting the application,
   * the user will be presented with a menus to Login, Register, or Exit.
   * Registering will store the user's info in the local database, and then
   * prompt the user to login. Upon logging in, the user will be presented
   * with a menu screen to select their shopping cart, categories, or orders.
   * Categories will take the user to the categories screen where they can
   * choose a category and see a list of those products and reviews. Upon
   * selecting a product the user can choose to put it into their cart or
   * not. Backing out to the menu screen, the user can look at their past
   * orders and the items in that order.
   */
  public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {
    logger.info("-------------- START APPLICATION --------------");
    Scanner scanner = new Scanner(System.in);

    // Create new router service with new Session
    Scanner scan = new Scanner(System.in);
    RouterService router = new RouterService(new Session());

    // Navigate to the home screen
    router.navigate("/home", scanner);

    logger.info("-------------- END APPLICATION ----------------");

    scan.close();

  }

}
