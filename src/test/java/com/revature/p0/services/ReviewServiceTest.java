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

    }

    @Test
    public void testGetReviewService() {

    }
}
