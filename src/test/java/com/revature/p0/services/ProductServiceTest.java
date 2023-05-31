package com.revature.p0.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.p0.daos.ProductDAO;
import com.revature.p0.models.Product;

public class ProductServiceTest {

    @Mock
    private ProductDAO productDAO;

    @InjectMocks
    private ProductService productService;

    @Before
    public void setUp() {
        // Initialize the Mockito framework
        MockitoAnnotations.openMocks(this);

        // Create a new instance of the UserService class with the mocked dependencies
        productService = new ProductService(productDAO);
    }

    @Test
    public void testFindAllByCategoryId() {
        String categoryId = "129fdkj";
        List<Product> product = new ArrayList<>();
        product.add(new Product("3inf5", "golden carrot", 50, "kj3kj2h"));
        product.add(new Product("345g5", "cake", 30, "kh23kj2h"));

        when(productDAO.findAllByCategoryId(categoryId)).thenReturn(product);

        List<Product> products = productService.findAllByCategoryId(categoryId);

        assertEquals(products, product);
    }
}
