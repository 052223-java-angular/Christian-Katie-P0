package com.revature.p0.services;

import java.util.List;

import com.revature.p0.daos.CheckoutDAO;
import com.revature.p0.models.CartItem;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CheckoutService {
    private final CheckoutDAO checkoutDAO;

    public List<CartItem> findAllByShoppingCartId(String id) {
        return this.checkoutDAO.findAllByShoppingCartId(id);
    }

    /*------------------------------Helper Method---------------------------*/

    public static CheckoutService getCheckoutService() {
        return new CheckoutService(new CheckoutDAO());
    }

}
