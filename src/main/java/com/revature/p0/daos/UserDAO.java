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

    // creating a user account and saving in database
    @Override
    public void save(User obj) {
        // create connection
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "INSERT INTO users (id, username, password, role_id) VALUES (?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, obj.getId());
                preparedStatement.setString(2, obj.getUsername());
                preparedStatement.setString(3, obj.getPassword());
                preparedStatement.setString(4, obj.getRoleId());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException sql) {
            throw new RuntimeException("Unable to access database to save user.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to save user.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to save user.");
        }
    }

    // retrieving the account from database so the user can login
    @Override
    public User findByID(String id) {
        User login = null;
        // create connection
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                login = new User(
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("password"));
            }
        } catch (SQLException sql) {
            throw new RuntimeException("Unable to access database to login user.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to login user.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to login user.");
        }
        return login;
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
                        user.setRoleId(resultSet.getString("role_id"));
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
    public List<User> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

}
