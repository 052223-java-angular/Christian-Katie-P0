package com.revature.p0.daos;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.p0.models.Review;
import com.revature.p0.utils.ConnectionFactory;

public class ReviewDAO implements CrudDAO<Review> {

    public List<Review> findReviewByProductId(String productId) {
        List<Review> reviews = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getInstance().getConnection()) {
            String sql = "SELECT * FROM reviews WHERE product_id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, productId);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        Review review = new Review(
                                resultSet.getString("id"),
                                resultSet.getInt("rating"),
                                resultSet.getString("comments"),
                                resultSet.getString("user_id"),
                                resultSet.getString("product_id"));
                        reviews.add(review);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Unable to access database to find reviews by product_id.");
        } catch (IOException io) {
            throw new RuntimeException("Cannot find application.properties to find reviews by product_id.");
        } catch (ClassNotFoundException cnf) {
            throw new RuntimeException("Unable to load jdbc to find reviews by product_id.");
        }
        return reviews;
    }

    @Override
    public void save(Review obj) {
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
    public Review findByID(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByID'");
    }

    @Override
    public List<Review> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }
}
