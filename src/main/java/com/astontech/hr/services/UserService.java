package com.astontech.hr.services;

import com.astontech.hr.domain.User;

import java.util.Iterator;

/**
 * Created by Bipin on 5/12/2016.
 */
public interface UserService {

    Iterable<User> listAllUsers();

    User getUserById(Integer id);

    User saveUser(User user);

    Iterable<User> saveUserList(Iterable<User> userIterable);

    void deleteUser(Integer id);
}
