package com.revature.p0.daos;

import java.io.IOException;
import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import com.revature.p0.models.Order;
import com.revature.p0.utils.ConnectionFactory;

public class OrderDAO implements CrudDAO<Order> {

    @Override
    public void save(Order obj) {
        // create connection
        // try (Connection connection = ConnectionFactory.getInstance().getConnection())
        // {
        // String sql = "INSERT INTO orders (id, created_at, total_cost, user_id) VALUES
        // (?, ?, ?, ?)";

        // try (PreparedStatement preparedStatement = connection.prepareStatement(sql))
        // {
        // preparedStatement.setString(1, obj.getId());
        // preparedStatement.setTimestamp(2, obj.getCreatedAt());
        // preparedStatement.setInt(3, obj.getTotalCost());
        // preparedStatement.setString(4, obj.getUserId());
        // preparedStatement.executeUpdate();
        // }

        // } catch (SQLException sql) {
        // throw new RuntimeException("Unable to access database to save user.");
        // } catch (IOException io) {
        // throw new RuntimeException("Cannot find application.properties to save
        // user.");
        // } catch (ClassNotFoundException cnf) {
        // throw new RuntimeException("Unable to load jdbc to save user.");
        // }
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

    // @Override
    // public List<Order> findAll() {
    // List<Order> order = new ArrayList<>();
    // try (Connection connection =
    // ConnectionFactory.getInstance().getConnection()){
    // String sql = "SELECT * FROM orders";

    // try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
    // ResultSet resultSet = preparedStatement.executeQuery();

    // while (resultSet.next()) {
    // order.add(new Order(
    // resultSet.getString("id"),
    // resultSet.getTimestamp("created_at"),
    // resultSet.getInt("total_cost"),
    // resultSet.getString("user_id")));
    // }
    // } catch (SQLException e) {
    // throw new RuntimeException("Unable to access database to save user.");
    // } catch (IOException io) {
    // throw new RuntimeException("Cannot find application.properties to save
    // user.");
    // } catch (ClassNotFoundException cnf) {
    // throw new RuntimeException("Unable to load jdbc to save user.");
    // }
    // return order;
    // }

    // }
}
