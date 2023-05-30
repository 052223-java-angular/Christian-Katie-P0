package com.revature.p0.screens;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.p0.services.ProductService;
import com.revature.p0.services.RouterService;
import com.revature.p0.services.ShoppingCartService;
import com.revature.p0.utils.Session;
import com.revature.p0.screens.ProductScreen;

import lombok.AllArgsConstructor;

@AllArgsConstructor


public class ShoppingCartScreen implements Screen{
    private ShoppingCartService shoppingCartService;
    private final RouterService router;
    private final Session session; 
    private static final Logger logger = LogManager.getLogger(ProductScreen.class);

    @Override
    public void start(Scanner scanner){
        String input = "";
        
        logger.info("User navigated to the shopping cart screen.");
        
        clearScreen();
        
        System.out.println("Welcome to your Shopping Cart.");
        //System.out.println("-Items-|-Price-|-Quantity-");

        // started the screen logic
        // if(session.isLoggedIn()){
        //     System.out.println("These are the current items in your shopping cart.");   
            
        // }
    }
    


     /*--------------------------------Helper Method-----------------------------*/
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


}
