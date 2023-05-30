package com.revature.p0.services;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.revature.p0.daos.RoleDAO;

public class RoleServiceTest {
    @Mock
    private RoleDAO roleDao;

    @InjectMocks
    private RoleService roleService;

    @Test
    public void testFindByName() {

    }
}
