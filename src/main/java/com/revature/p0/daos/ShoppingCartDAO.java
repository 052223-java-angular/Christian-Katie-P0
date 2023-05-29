package com.revature.p0.daos;

import com.revature.p0.models.ShoppingCart;
import java.util.*;

import javax.annotation.processing.Generated;

import java.sql.*;
import com.revature.p0.utils.*;

public class ShoppingCartDAO {

     /*
     * @param showShoppingCart(shopping cart) is connecting to the local database and shows all the items
     *  that a user has in their shopping cart. If the cart is empty then it will say the shopping cart is
     *  empty.
     * 
     * @return the related exception message should anything happen at runtime.
     * If the method runs correctly, it will return all items in the user's cart.
     * 
     * 
     * @author Christian Fernandez
     */

    public ShoppingCart showShoppingCart(ShoppingCart shoppingCart) {

        // connecting to data base
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT product_id FROM cart_items WHERE shopping_cart_id = ?"; // getting products

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        ShoppingCart sc = new ShoppingCart(rs.getString("id"), rs.getString("user_id"));
                        return sc; // Might need to return Optional.of(sc)
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
