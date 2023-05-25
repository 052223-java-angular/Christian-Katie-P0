package com.revature.p0.services;

import java.util.Scanner;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.screens.HomeScreen;
import com.revature.p0.screens.RegisterScreen;

public class RouterService {

    public void navigate(String path, Scanner scan) {
        switch (path) {
            case "/home":
                new HomeScreen(this).start(scan);
                break;
            case "/login":
                break;
            case "/register":
                new RegisterScreen(getUserService()).start(scan);
                break;
            case "/review":
                break;
            default:
                break;
        }
    }

    /* ------------------- Helper Method --------------- */

    private UserService getUserService() {
        return new UserService(new UserDAO());
    }
}
