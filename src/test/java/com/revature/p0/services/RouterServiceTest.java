package com.revature.p0.services;

import static org.mockito.Mockito.verify;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.p0.screens.CategoryScreen;
import com.revature.p0.screens.HomeScreen;
import com.revature.p0.screens.LoginScreen;
import com.revature.p0.screens.MenuScreen;
import com.revature.p0.screens.OrderScreen;
import com.revature.p0.screens.ProductScreen;
import com.revature.p0.screens.RegisterScreen;
import com.revature.p0.utils.Session;

public class RouterServiceTest {
    @Mock
    private HomeScreen homeScreen;
    @Mock
    private LoginScreen loginScreen;
    @Mock
    private MenuScreen menuScreen;
    @Mock
    private RegisterScreen registerScreen;
    @Mock
    private CategoryScreen categoryScreen;
    @Mock
    private OrderScreen orderScreen;
    @Mock
    private ProductScreen productScreen;
    @Mock
    private Session session;

    private RouterService routerService;

    @Before
    public void setUp() {
        // Initialize the Mockito framework
        MockitoAnnotations.openMocks(this);

        // Create a new instance of the UserService class with the mocked dependencies
        routerService = new RouterService(session);
    }

    @Test
    public void testNavigateHome() {
        String home = "/home";
        Scanner scanner = new Scanner(System.in);
        routerService.navigate(home, scanner);
        verify(homeScreen).start(scanner);
    }

    @Test
    public void testNavigateLogin() {
        String login = "/login";
        Scanner scanner = new Scanner(System.in);
        routerService.navigate(login, scanner);
        verify(loginScreen).start(scanner);
    }

    @Test
    public void testNavigateMenu() {
        String menu = "/menu";
        Scanner scanner = new Scanner(System.in);
        routerService.navigate(menu, scanner);
        verify(menuScreen).start(scanner);

    }

    @Test
    public void testNavigateRegister() {
        String register = "/register";
        Scanner scanner = new Scanner(System.in);
        routerService.navigate(register, scanner);
        verify(registerScreen).start(scanner);

    }

    @Test
    public void testNavigateCategory() {
        String category = "/category";
        Scanner scanner = new Scanner(System.in);
        routerService.navigate(category, scanner);
        verify(categoryScreen).start(scanner);

    }

    @Test
    public void testNavigateOrder() {
        String order = "/order";
        Scanner scanner = new Scanner(System.in);
        routerService.navigate(order, scanner);
        verify(orderScreen).start(scanner);

    }

}
