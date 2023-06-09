package com.revature.p0.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.Role;
import com.revature.p0.models.User;

public class UserService {
    private final UserDAO userDAO;
    private final RoleService roleService;

    public UserService(UserDAO userDAO, RoleService roleService) {
        this.userDAO = userDAO;
        this.roleService = roleService;
    }

    public User register(String username, String password) {
        Role foundRole = roleService.findByName("USER");
        String hashed = BCrypt.hashpw(password, BCrypt.gensalt());
        User newUser = new User(username, hashed, foundRole.getId());
        userDAO.save(newUser);
        return newUser;
    }

    public User login(String username, String password) {
        Optional<User> existingUser = userDAO.findByUsername(username);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            if (BCrypt.checkpw(password, user.getPassword())) {
                return user;
            }
        }
        return null;
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
}
