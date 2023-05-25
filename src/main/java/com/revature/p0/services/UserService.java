package com.revature.p0.services;

import java.util.Optional;

import javax.management.relation.RoleNotFoundException;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.Roles;
import com.revature.p0.models.User;

public class UserService {
    private final UserDAO userDAO;
    private final RoleService roleService;

    public UserService(UserDAO userDAO, RoleService roleService) {
        this.userDAO = userDAO;
        this.roleService = roleService;
    }

    public User register(String username, String password) throws RoleNotFoundException {
        Roles foundRole = roleService.findByName("USER");
        String hashed = BCrypt.hashpw(username, BCrypt.gensalt());
        User newUser = new User(username, hashed, foundRole);
        userDAO.save(newUser);
        return newUser;
    }

    public boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$");
    }

    public boolean isUniqueUsername(String username) {
        UserDAO userDAO = new UserDAO();
        Optional<User> userOpt = userDAO.findByUsername(username);

        if (userOpt.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$");
    }

    public boolean isSamePassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    // public boolean isSameEmail(String email) {
    // User user = userDAO.findByID(email);

    // if (user.isEmpty()) {
    // return true;
    // }
    // return false;
    // }
}
