package com.revature.p0.services;

import java.util.Scanner;

import com.revature.p0.daos.RoleDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.screens.HomeScreen;
import com.revature.p0.screens.LoginScreen;
import com.revature.p0.screens.MenuScreen;
import com.revature.p0.screens.RegisterScreen;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RouterService {
    private Session session;

    public void navigate(String path, Scanner scanner) {
        switch (path) {
            case "/home":
                new HomeScreen(this).start(scanner);
                break;
            case "/login":
                new LoginScreen(getUserService(), this, session).start(scanner);
                break;
            case "/menu":
                new MenuScreen(session).start(scanner);
                break;
            case "/register":
                new RegisterScreen(getUserService(), this, session).start(scanner);
                break;
            case "/review":
                break;
            default:
                break;
        }
    }

    /* ------------------- Helper Method --------------- */

    private UserService getUserService() {
        return new UserService(new UserDAO(), getRoleService());
    }

    private RoleService getRoleService() {
        return new RoleService(new RoleDAO());
    }
}
