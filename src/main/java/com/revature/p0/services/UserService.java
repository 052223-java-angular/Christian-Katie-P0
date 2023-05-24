package com.revature.p0.services;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.daos.UserDAOImpl;

public class UserService {

    private final UserDAO userDAO = new UserDAOImpl() {

    };
}
