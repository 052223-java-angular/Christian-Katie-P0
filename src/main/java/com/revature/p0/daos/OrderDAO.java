package com.revature.p0.daos;

import java.io.IOException;
// import java.security.Timestamp;
import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.models.Order;
import com.revature.p0.models.OrderItems;
import com.revature.p0.utils.ConnectionFactory;

public class OrderDAO implements CrudDAO<Order> {

    /*
     * @param save() method is connecting to the local database and saving the
     * orders each user makes after purchase. The method takes in the order id,
     * date, total, and user id. There is no result set and the method does not
     * return anything because data is being inserted into the orders table in
     * the database.
     * 
     * @author Katie Osborne
     */

    @Override
    public void save(Order obj) {
        // create connection
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO orders (id, created_at, total_cost, user_id) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, obj.getId());
                preparedStatement.setObject(2, obj.getCreatedAt());
                preparedStatement.setInt(3, obj.getTotalCost());
                preparedStatement.setString(4, obj.getUserId());
                preparedStatement.executeUpdate();
            }
        } catch (SQLException sql) {
            throw new RuntimeException("Unable to access database to save order.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to save order.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to save order.");
        }
    }

    /*
     * @param findAllByUsername() method is connected to the local database and
     * retrieves orders based on a user's username by joining orders and users
     * on the user id.
     * 
     * An empty array list is instantiated and named orders. Once the correct query
     * is selected through the join, the result set is added to a new order object
     * and returned.
     * 
     * @return the orders list containing the orders by username.
     * 
     * @author Katie Osborne
     */

    public List<Order> findAllByUsername(String username) {
        List<Order> orders = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT orders.id, orders.created_at, orders.total_cost, orders.user_id FROM orders JOIN users ON orders.user_id = users.id WHERE users.username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Order order = new Order(
                                resultSet.getString("id"),
                                resultSet.getObject("created_at", Timestamp.class).toString(),
                                resultSet.getInt("total_cost"),
                                resultSet.getString("user_id"));
                        orders.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to access database to find all orders.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to find all orders.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to find all orders.");
        }
        return orders;
    }
    /*
     * @param findAllByOrderItemId() method is connected to the local database and
     * retrieves order items based on the order item's id.
     * 
     * An empty array list is instantiated and named orderItems. Once the correct
     * query is selected, the result set is added to a new order object and
     * returned.
     * 
     * @return the orderItems list containing the orderItems by order item id.
     * 
     * @author Katie Osborne
     */

    public List<OrderItems> findAllByOrderItemId(String id) {
        List<OrderItems> orderItems = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM order_items WHERE order_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        OrderItems order = new OrderItems(
                                resultSet.getString("id"),
                                resultSet.getInt("quantity"),
                                resultSet.getInt("price"),
                                resultSet.getString("order_id"),
                                resultSet.getString("product_id"));
                        orderItems.add(order);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to access database to find all orderItems.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to find all orderItems.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to find all orderItems.");
        }
        return orderItems;
    }
    /*
     * @param findProductNameById() method is connected to the local database and
     * retrieves a product name by product id.
     * 
     * An empty string is declared and named productName. Once the product name
     * is queried, the result set is returned.
     * 
     * @return productName.
     * 
     * @author Katie Osborne
     */

    public String findProductNameById(String productId) {
        String productName = "";

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT name FROM products WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, productId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        productName = resultSet.getString("name");
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to access database to find product name by id.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to find product name by id.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to find product name by id.");
        }

        return productName;
    }

    @Override
    public List<Order> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
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
    public Order findByID(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }
}