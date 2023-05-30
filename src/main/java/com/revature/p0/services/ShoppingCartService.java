package com.revature.p0.services;

import com.revature.p0.daos.ShoppingCartDAO;
import com.revature.p0.models.CartItem;
import com.revature.p0.models.ShoppingCart;
import java.util.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor

public class ShoppingCartService {
    private final ShoppingCartDAO shoppingCartDAO;

    public ShoppingCart showShoppingCart(ShoppingCart shoppingCart){
        return this.shoppingCartDAO.showShoppingCart(shoppingCart);
    }

    public CartItem addToShoppingCart(CartItem cartItem){
        return shoppingCartDAO.addToShoppingCart(cartItem);
    }

    /*------------------------------Helper Method---------------------------*/
    public static ShoppingCartService gShoppingCartService(){
        return new ShoppingCartService(new ShoppingCartDAO());
    }

}
