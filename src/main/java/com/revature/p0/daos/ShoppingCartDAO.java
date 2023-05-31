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

    public CartItem addToShoppingCart(CartItem cartItem) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO cart_items (quantity) VALUES (?)";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setInt(1, ((CartItem) ps).getQuantity());
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        // int generatedMsgID = (int) rs.getLong(1);
                      
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

    // Get a product by its ID
    public Product getProductByID(String productID){
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM products WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, productID);
                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        Product product = new Product(rs.getString("id"), rs.getString("name"), rs.getInt("price"), rs.getString("category_id"));
                        return product;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Could not get product by its ID.");
            e.printStackTrace();
        }
        return null;
    }


    // Get a Cart Item by its ID
    public CartItem getCartItemByID(String cartItemID){
        try(Connection connection = ConnectionFactory.getInstance().getConnection()){
            String sql = "SELECT * FROM cart_items WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, cartItemID);
                try(ResultSet rs = ps.executeQuery()){
                    while(rs.next()){
                        CartItem cartItem = new CartItem(rs.getString("id"), rs.getInt("price"), rs.getInt("quantity"), rs.getString("shopping_cart_id"), rs.getString("product_id"));
                        return cartItem;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Could not get cart item by its ID.");

            e.printStackTrace();
        }
        return null;
    }



    // Remove an item from user cart
    public CartItem removeItem(String cartItemID){
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            String sql = "DELETE FROM cart_items WHERE product_id = ?";
            CartItem cartItem = getCartItemByID(cartItemID);
           // CartItem product = 

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setString(1, cartItemID);
                try(ResultSet rs = ps.executeQuery()){
                    if(cartItem != null){
                        return cartItem;
                    }
                }
            }
        }
        catch(Exception e){
            System.out.println("Can not remove item from cart.");
            e.printStackTrace();
        }
        return null;
    }

    // Change quantity in cart
    public void changeQuantity(String cartItemID, CartItem cartItem){
        try (Connection connection = ConnectionFactory.getInstance().getConnection()){
            String sql = "UPDATE cart_items SET quantity = ? WHERE id = ?";
            try(PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setInt(1, cartItem.getQuantity());
                ps.setString(2, cartItemID);
                ps.executeUpdate();
            }
        }
        catch(Exception e){
            System.out.print("Can not change quantity.");
            e.printStackTrace();
        }
    }



}
