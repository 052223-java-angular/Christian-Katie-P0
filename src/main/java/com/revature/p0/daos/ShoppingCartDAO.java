package com.revature.p0.daos;

import com.revature.p0.models.ShoppingCart;
import com.revature.p0.models.CartItem;
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
     * @param addToShoppingCart(cart items) is connectiong to the local database and allows the user
     * to add items to their shopping cart.
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
            System.out.println("Can Not Show Shopping Cart.");
            e.printStackTrace();
        }
        return null;
    }

    public CartItem addToShoppingCart(CartItem cartItem){
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            String sql = "INSERT INTO cart_items (quantity) VALUES (?)";

            try(PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                ps.setInt(1, ((CartItem) ps).getQuantity());
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        //int generatedMsgID = (int) rs.getLong(1);
                        String generatedID = rs.getString(1); // generated cart item id
                        // int getPrice = rs.getInt(2); // price
                        // String shpCartID = rs.getString(3); // shopping cart ID
                        // String productID = rs.getString(4); // product ID
                        return new CartItem(generatedID, cartItem.getPrice(), cartItem.getQuantity(), cartItem.getShoppingCartId(), cartItem.getProductId());
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Can Not Add Item To Cart.");
            e.printStackTrace();
        }

        return null;
    }



}
