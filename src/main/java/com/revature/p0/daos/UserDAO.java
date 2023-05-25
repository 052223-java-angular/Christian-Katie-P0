package com.revature.p0.daos;

import java.util.List;

import com.revature.p0.models.User;

public interface UserDAO<User> {

    // create user
    void saveUser(User object);

    // update a user
    void updateUserById(String id);

    // delete a user
    void deleteUserById(String id);

    // find a user by the user_id
    User findUserById(String id);

    // get all users
    List<User> getAllUsers();
}
