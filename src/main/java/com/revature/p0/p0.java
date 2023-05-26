package com.revature.p0;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.revature.p0.services.RouterService;
import com.revature.p0.utils.Session;

public class p0 {
  public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException {

    Scanner scan = new Scanner(System.in);
    RouterService router = new RouterService(new Session());
    router.navigate("/home", scan);
    scan.close();

  }

}
