package com.revature.p0.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.revature.p0.models.Product;
import com.revature.p0.utils.ConnectionFactory;

public class ProductDAO implements CrudDAO<Product> {

    @Override
    public void save(Product obj) {
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
    public Product findByID(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    @Override
    public List findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    public List<Product> findAllByCategoryId(String id) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT name, price FROM products WHERE category_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Product product = new Product(
                                resultSet.getString("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getString("categoryId"));
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to access database for products.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties for products.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc for products.");
        }
        return products;
    }
}
