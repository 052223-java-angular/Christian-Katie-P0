package com.revature.p0.services;

import java.util.Scanner;

import com.revature.p0.daos.ProductDAO;
import com.revature.p0.daos.RoleDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.screens.CategoryScreen;
import com.revature.p0.screens.HomeScreen;
import com.revature.p0.screens.LoginScreen;
import com.revature.p0.screens.MenuScreen;
import com.revature.p0.screens.ProductScreen;
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
                new MenuScreen(this, session).start(scanner);
                break;
            case "/register":
                new RegisterScreen(getUserService(), this, session).start(scanner);
                break;
            case "/review":
                break;
            case "/shoppingCart":
                break;
            case "/category":
                new CategoryScreen(getProductService(), this, session).start(scanner);
                break;
            case "/order":
                break;
            case "/product/redstone":
                new ProductScreen(getProductService(), this, session).RedstoneProducts(scanner);
                break;
            case "/product/potion":
                new ProductScreen(getProductService(), this, session).PotionProducts(scanner);
                break;
            case "/product/tool":
                new ProductScreen(getProductService(), this, session).ToolProducts(scanner);
                break;
            case "/product/weapon":
                new ProductScreen(getProductService(), this, session).WeaponProducts(scanner);
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

    private ProductService getProductService() {
        return new ProductService(new ProductDAO());
    }

}
