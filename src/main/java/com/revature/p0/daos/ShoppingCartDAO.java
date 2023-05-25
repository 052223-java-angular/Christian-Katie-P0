package com.revature.p0.daos;

import com.revature.p0.models.ShoppingCart;
import java.util.*;

import javax.annotation.processing.Generated;

import java.sql.*;
import com.revature.p0.utils.*;

public class ShoppingCartDAO {

    // Create a shopping cart to link to a user that exist
    public ShoppingCart addShopping_Cart(ShoppingCart shoppingCart) {

        // connecting to data base
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO shopping_cart (id, user_id) VALUES (?, ?)";

            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        ShoppingCart sc = new ShoppingCart();
                        sc.setId(rs.getString("id"));
                        sc.setUser_id(rs.getString("user_id"));
                        return sc; // Might need to return Optional.of(sc)
                        // Comment
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
