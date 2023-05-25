package com.revature.p0.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.revature.p0.models.User;
import com.revature.p0.utils.ConnectionFactory;

public class UserDAO implements CrudDAO<User> {

    @Override
    public void save(User obj) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO users (id, username, password, email) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, obj.getId());
                preparedStatement.setString(2, obj.getUsername());
                preparedStatement.setString(3, obj.getPassword());
                preparedStatement.setString(4, obj.getEmail());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException sql) {
            throw new RuntimeException("Unable to access database.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc.");
        }
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
    public User findByID(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    @Override
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public Optional<User> findByUsername(String username) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        User user = new User();
                        user.setId(resultSet.getString("id"));
                        user.setUsername(resultSet.getString("username"));
                        user.setPassword(resultSet.getString("password"));
                        user.setEmail(resultSet.getString("email"));
                        return Optional.of(user);
                    }
                }
            }

        } catch (SQLException sql) {
            throw new RuntimeException("Unable to access database.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc.");
        }

        return Optional.empty();
    }

}