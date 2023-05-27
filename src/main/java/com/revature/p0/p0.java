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

  // Entry point of the application
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
