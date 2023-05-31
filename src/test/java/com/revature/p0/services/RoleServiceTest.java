package com.revature.p0.services;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.revature.p0.daos.RoleDAO;
import com.revature.p0.models.Role;

public class RoleServiceTest {
    @Mock
    private RoleDAO roleDAO;

    @InjectMocks
    private RoleService roleService;

    @Before
    public void setUp() {
        // Initialize the Mockito framework
        MockitoAnnotations.openMocks(this);

        // Create a new instance of the UserService class with the mocked dependencies
        roleService = new RoleService(roleDAO);
    }

    @Test
    public void testFindByName() {
        String roleName = "USER";
        Role mockRole = new Role("id", roleName);
        when(roleDAO.findByName(roleName)).thenReturn(Optional.of(mockRole));

        Optional<Role> result = Optional.ofNullable(roleService.findByName(roleName));

        assertEquals(Optional.of(mockRole), result);
    }
}
