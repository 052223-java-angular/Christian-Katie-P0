package com.revature.p0.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import com.revature.p0.models.Roles;
import com.revature.p0.utils.ConnectionFactory;

public class RoleDAO implements CrudDAO<Role> {

    @Override
    public void save(Role obj) {
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
    public Role findByID(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    @Override
    public List<Role> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public Optional<Roles> findByName(String name) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM roles WHERE name = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Roles roles = new Roles();
                        roles.setId(resultSet.getString("id"));
                        roles.setName(resultSet.getString("name"));
                        return Optional.of(roles);
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
