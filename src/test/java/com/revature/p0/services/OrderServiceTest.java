package com.revature.p0.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.p0.daos.OrderDAO;
import com.revature.p0.daos.ProductDAO;
import com.revature.p0.models.Order;
import com.revature.p0.models.OrderItems;
import com.revature.p0.models.Product;

public class OrderServiceTest {
    @Mock
    private OrderDAO orderDAO;
    @Mock
    private ProductDAO productDAO;

    @InjectMocks
    private OrderService orderService;
    private ProductService productService;

    @Before
    public void setUp() {
        // Initialize the Mockito framework
        MockitoAnnotations.openMocks(this);

        // Create a new instance of the UserService class with the mocked dependencies
        orderService = new OrderService(orderDAO);
    }

    @Test
    public void testFindAllByOrderItemId() {
        // String order = "32hf";
        // List<Order> orders = new ArrayList<>();
        // order.add("2n4k", 125, 265, "69fds", "3knkf");
        // order.add("32kjs", 100, 150, "24eef", " 2j14");

        // when(orderDAO.findAllByOrderItemId(order)).thenReturn(orders);

        // List<OrderItems> result = orderService.findAllByOrderItemId(order);

        // assertEquals(orders, result);
    }

    @Test
    public void testFindAllByUsername() {
        String username = "Revature32";
        List<Order> orders = Collections.singletonList(new Order("123456", username, 250, "itemid123"));

        when(orderDAO.findAllByUsername(username)).thenReturn(orders);

        List<Order> result = orderService.findAllByUsername(username);

        assertEquals(orders, result);
    }

    @Test
    public void testFindProductNameById() {
        // String productId = "3jhf";
        // String productName = "Golden Apple";

        // when(productDAO.findByID(productId)).thenReturn(new Product("32oihv", "Golden
        // Apple", 50, "389u"));

        // String product = productService.findByID(productId);
        // assertEquals(productName, product);
    }

    @Test
    public void testSave() {
        List<Order> order = new ArrayList<>();
        order.add(new Order(" 3289fj0", "wkwev", 240, "2390ff"));
        order.add(new Order(" 32doifj0", "34vev", 3000, "23932hf"));

        for (Order orders : order) {
            String orderId = UUID.randomUUID().toString();
        }

        verify(orderDAO, times(order.size()));
    }
}
