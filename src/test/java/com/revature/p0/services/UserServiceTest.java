package com.revature.p0.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.Role;
import com.revature.p0.models.User;

public class UserServiceTest {

    @Mock
    private UserDAO userDAO;
    @Mock
    private RoleService roleService;

    private UserService userService;

    @Before
    public void setUp() {
        // Initialize the Mockito framework
        MockitoAnnotations.openMocks(this);

        // Create a new instance of the UserService class with the mocked dependencies
        userService = new UserService(userDAO, roleService);
    }

    @Test
    public void testRegister() {
        // Define the test input values
        String username = "testUser";
        String password = "testPassword";

        Role role = new Role("weknvoi392", "USER");
        User expected = new User(username, BCrypt.hashpw(password, BCrypt.gensalt()), role.getId());

        when(roleService.findByName("USER")).thenReturn(role);
        doNothing().when(userDAO).save(any(User.class));

        User user = userService.register(username, password);

        verify(userDAO, times(1)).save(any(User.class));

        assertEquals(expected.getUsername(), user.getUsername());
    }

    @Test
    public void testIsValidUsername() {
        String validUsername = "validUser";
        String invalidUsername = "";

        assertTrue(userService.isValidUsername(validUsername));
        assertFalse(userService.isValidUsername(invalidUsername));
    }

    // @Test
    // public void testIsUniqueUsername() {
    // String existingUsername = "existingUser";
    // String newUsername = "newUser";

    // when(userDAO.findByUsername(existingUsername)).thenReturn(Optional.of(new
    // User()));
    // when(userDAO.findByUsername(newUsername)).thenReturn(Optional.empty());

    // assertFalse(userService.isUniqueUsername(existingUsername));
    // assertTrue(userService.isUniqueUsername(newUsername));
    // }

    @Test
    public void testIsValidPassword() {
        String validPassword = "Valid123";
        String invalidPassword = "invalid";

        assertTrue(userService.isValidPassword(validPassword));
        assertFalse(userService.isValidPassword(invalidPassword));
    }

    @Test
    public void testIsSamePassword() {
        String password = "password123";
        String confirmPassword = "password123";
        String differentPassword = "differentPassword123";

        assertTrue(userService.isSamePassword(password, confirmPassword));
        assertFalse(userService.isSamePassword(password, differentPassword));
    }
}
