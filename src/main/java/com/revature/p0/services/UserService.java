package com.revature.p0.services;

import java.util.Optional;

import javax.swing.text.html.Option;

import com.revature.p0.daos.UserDAO;
import com.revature.p0.models.User;

import lombok.AllArgsConstructor;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User register(String username, String password) {

        return null;
    }

    public boolean isValidUsername(String username) {
        return username.matches("^[a-zA-Z0-9]+([._]?[a-zA-Z0-9]+)*$");
    }

    public boolean isUniqueUsername(String username) {
        Optional<User> userOpt = userDAO.findUserById(username);

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

    public boolean isSameEmail(String email) {
        User user = userDAO.findUserById(email);

        if (user.isEmpty()) {
            return true;
        }
        return false;
    }
}
