package com.revature.p0.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.revature.p0.models.User;
import com.revature.p0.utils.ConnectionFactory;

public class UserDAOImpl implements UserDAO {

    // // creating a new user
    // @Override
    // public void create(User user) {
    // // getting connection
    // try {
    // Connection connection = new ConnectionFactory.getConnection()
    // // sql query
    // String sql = "INSERT INTO users (username, password, email) VALUES (?, ?,
    // ?)";
    // // prepared statement converting to query
    // PreparedStatement preparedStatement = connection.prepareStatement(sql);
    // preparedStatement.setString(1, user.getUsername());
    // preparedStatement.setString(2, user.getPassword());
    // preparedStatement.setString(3, user.getEmail());
    // preparedStatement.execute();
    // // result set to retrieve records and store in models
    // ResultSet resultSet = preparedStatement.getResultSet();

    // } catch(SQLException sql) {
    // System.out.println("UserDAO SQLException.");
    // }

    // }

    // @Override
    // public List<User> getAllUsers() {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'getAllUsers'");
    // }

    // @Override
    // public void getUserById(String id) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'getUserById'");
    // }

    // @Override
    // public void updateUserById(String id) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'updateUserById'");
    // }

    // @Override
    // public void deleteUserById(String id) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'deleteUserById'");
    // }

    // @Override
    // public void getUserByUsername(String username) {
    // // TODO Auto-generated method stub
    // throw new UnsupportedOperationException("Unimplemented method
    // 'getUserByUsername'");
    // }

}
