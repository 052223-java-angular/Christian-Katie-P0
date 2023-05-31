package com.revature.p0.services;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.daos.CheckoutDAO;
import com.revature.p0.daos.OrderDAO;
import com.revature.p0.daos.ProductDAO;
import com.revature.p0.daos.ReviewDAO;
import com.revature.p0.daos.RoleDAO;
import com.revature.p0.daos.ShoppingCartDAO;
import com.revature.p0.daos.UserDAO;
import com.revature.p0.screens.CategoryScreen;
//import com.revature.p0.screens.CheckoutScreen;
import com.revature.p0.screens.HomeScreen;
import com.revature.p0.screens.LoginScreen;
import com.revature.p0.screens.MenuScreen;
import com.revature.p0.screens.OrderScreen;
import com.revature.p0.screens.ProductScreen;
import com.revature.p0.screens.RegisterScreen;
import com.revature.p0.utils.Session;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RouterService {
    private Session session;
    private static final Logger logger = LogManager.getLogger(RouterService.class);

    public void navigate(String path, Scanner scanner) {
        switch (path) {
            case "/home":
                logger.info("Navigating to the HomeScreen.");
                new HomeScreen(this).start(scanner);
                break;
            case "/login":
                logger.info("Navigating to the LoginScreen.");
                new LoginScreen(getUserService(), this, session).start(scanner);
                break;
            case "/menu":
                logger.info("Navigating to the MenuScreen.");
                new MenuScreen(this, session).start(scanner);
                break;
            case "/register":
                logger.info("Navigating to the RegisterScreen.");
                new RegisterScreen(getUserService(), this, session).start(scanner);
                break;
            case "/review":
                logger.info("Navigating to the ReviewScreen.");
                break;
            case "/shoppingCart":
                logger.info("Navigating to the ShoppingCartScreen.");
                //new ShoppingCartScreen() NEED SHOPPING CART SCREEN
                break;
            case "/category":
                logger.info("Navigating to the CategoryScreen.");
                new CategoryScreen(getReviewService(), getProductService(), this, session).start(scanner);
                break;
            case "/order":
                logger.info("Navigating to the OrderScreen.");
                new OrderScreen(getOrderService(), this, session).start(scanner);
                break;
            case "/product/redstone":
                logger.info("Navigating to the ProductScreen.");
                new ProductScreen(getReviewService(), getProductService(), this, session).RedstoneProducts(scanner);
                break;
            case "/product/potion":
                logger.info("Navigating to the ProductScreen.");
                new ProductScreen(getReviewService(), getProductService(), this, session).PotionProducts(scanner);
                break;
            case "/product/tool":
                logger.info("Navigating to the ProductScreen.");
                new ProductScreen(getReviewService(), getProductService(), this, session).ToolProducts(scanner);
                break;
            case "/product/weapon":
                logger.info("Navigating to the ProductScreen.");
                new ProductScreen(getReviewService(), getProductService(), this, session).WeaponProducts(scanner);
                break;
            case "/checkout":
                logger.info("Navigating to the CheckoutScreen.");
                // new CheckoutScreen(getCheckoutService(), this, session).start(scanner);
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

    private OrderService getOrderService() {
        return new OrderService(new OrderDAO());
    }

    public static ReviewService getReviewService() {
        return new ReviewService(new ReviewDAO());
    }

    public static CheckoutService getCheckoutService() {
        return new CheckoutService(new CheckoutDAO());
    }

}
