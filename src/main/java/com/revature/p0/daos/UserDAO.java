package com.revature.p0.daos;

import java.util.List;

import com.revature.p0.models.User;

public interface UserDAO<T> {

    // create user
    void saveUser(T object);

    // update a user
    void updateUserById(String id);

    // delete a user
    void deleteUserById(String id);

    // find a user by the user_id
    T findUserById(String id);

    // get all users
    List<T> getAllUsers();

    // find a user by their username
    void getUserByUsername(String username);

}
