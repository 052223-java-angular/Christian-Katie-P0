package com.revature.p0.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.p0.daos.ReviewDAO;
import com.revature.p0.models.Review;

public class ReviewServiceTest {

    @Mock
    private ReviewDAO reviewDAO;

    @InjectMocks
    private ReviewService reviewService;

    @Before
    public void setUp() {
        // Initialize the Mockito framework
        MockitoAnnotations.openMocks(this);

        // Create a new instance of the UserService class with the mocked dependencies
        reviewService = new ReviewService(reviewDAO);
    }

    @Test
    public void testFindReviewByProductId() {
        // Define the test input values
        String productId = "testProductId";
        List<Review> reviews = Arrays.asList(
                new Review("1", 4, "Good!", "23dd--dn4q2d--n4jd0", "2344fjkjrh"),
                new Review("1", 5, "Good!", "23dd--meksd--n4jtg0", "23567kjrh"));

        // Mock the behavior of the reviewRepository object
        when(reviewDAO.findReviewByProductId(productId)).thenReturn(reviews);

        // Call the findReviewByProductId method of the reviewService object with the
        // test input values
        List<Review> result = reviewService.findReviewByProductId(productId);

        // Verify that the reviewRepository.findByProductId method was called once with
        // the expected productId value as an argument
        verify(reviewDAO, times(1)).findReviewByProductId(productId);

        // Verify that the result object has the expected list of reviews
        assertEquals(reviews, result);
    }

    @Test
    public void testGetReviewService() {

    }
}
