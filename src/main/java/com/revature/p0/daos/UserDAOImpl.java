package com.revature.p0.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.naming.spi.DirStateFactory.Result;

import com.revature.p0.models.User;
import com.revature.p0.utils.ConnectionFactory;

public class UserDAOImpl implements UserDAO<User> {

    @Override
    public void saveUser(User object) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveUser'");
    }

    @Override
    public void updateUserById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUserById'");
    }

    @Override
    public void deleteUserById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserById'");
    }

    @Override
    public User findUserById(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUserById'");
    }

    @Override
    public List<User> getAllUsers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllUsers'");
    }

    public Optional<User> finByUsername(String username) {
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