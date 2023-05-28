package com.revature.p0.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.revature.p0.models.Product;
import com.revature.p0.utils.ConnectionFactory;

public class ProductDAO implements CrudDAO<Product> {

    /*
     * @param findAllByCategoryId() method is connecting to the local database
     * and retrieving all products by the category_id. This keeps the products
     * organized by category instead of retrieving all the products at once.
     * 
     * @return the related exception message should anything happen at runtime.
     * If the method runs correctly, it will return the product's id, name, price,
     * and category_id given a specific category id.
     * 
     * @author Katie Osborne
     */

    public List<Product> findAllByCategoryId(String id) {
        // System.out.println("Inside find all by category id");

        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM products WHERE category_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, id);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Product product = new Product(
                                resultSet.getString("id"),
                                resultSet.getString("name"),
                                resultSet.getInt("price"),
                                resultSet.getString("category_id"));
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
}
