package com.revature.p0.daos;

import com.revature.p0.models.Shopping_Cart;
import java.util.*;

import javax.annotation.processing.Generated;

import java.sql.*;
import com.revature.p0.utils.*;


public class ShoppingCartDAO {
   
    // Create a shopping cart to link to a user that exist
    public Shopping_Cart addShopping_Cart(Shopping_Cart shoppingCart){
        
        // connecting to data base
        try(Connection connection = ConnectionFactory.getInstance().getConnection() ){
            String sql = "INSERT INTO shopping_cart (id, user_id) VALUES (?, ?)";

            try(PreparedStatement ps = connection.prepareStatement(sql)){
                try(ResultSet rs = ps.executeQuery()){
                    if(rs.next()){
                        Shopping_Cart sc = new Shopping_Cart();
                        sc.setId(rs.getString("id"));
                        sc.setUser_id(rs.getString("user_id"));
                        return sc; // Might need to return Optional.of(sc)
                    }
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return null;
    }




    

}
