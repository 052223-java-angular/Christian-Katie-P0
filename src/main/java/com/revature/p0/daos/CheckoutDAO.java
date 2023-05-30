package com.revature.p0.daos;

import java.io.IOException;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.models.CartItem;
import com.revature.p0.utils.ConnectionFactory;

public class CheckoutDAO implements CrudDAO<CartItem> {

    public List<CartItem> findAllByShoppingCartId(String id) {
        List<CartItem> cartItems = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM cart_items WHERE shopping_cart_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        CartItem cartItem = new CartItem(
                                resultSet.getString("id"),
                                resultSet.getInt("quantity"),
                                resultSet.getInt("price"),
                                resultSet.getString("order_id"),
                                resultSet.getString("product_id"));
                        cartItems.add(cartItem);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to access database to find all orderItems.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to find all orderItems.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to find all orderItems.");
        }
        return cartItems;
    }

    @Override
    public void save(CartItem obj) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public CartItem findByID(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    @Override
    public List<CartItem> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }
}
