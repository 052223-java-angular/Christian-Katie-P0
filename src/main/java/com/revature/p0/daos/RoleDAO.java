package com.revature.p0.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.revature.p0.models.Role;
import com.revature.p0.utils.ConnectionFactory;

public class RoleDAO implements CrudDAO<Role> {
    /*
     * @param findByName() method selects all the types of user roles and returns
     * them by the name of the role. This is done because the role id is hashed
     * with a UUID.
     * 
     * @return the name of the role requested from the database.
     * 
     * @return empty if there is no match to the requested role.
     * 
     * @author Katie Osborne
     */
    public Optional<Role> findByName(String name) {
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM roles WHERE name = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, name);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        Role roles = new Role();
                        roles.setId(resultSet.getString("id"));
                        roles.setName(resultSet.getString("name"));

                        return Optional.of(roles);
                    }
                }
            }

        } catch (SQLException sql) {
            throw new RuntimeException("Unable to access database for role.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties for role.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc for role.");
        }

        return Optional.empty();
    }

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

}
