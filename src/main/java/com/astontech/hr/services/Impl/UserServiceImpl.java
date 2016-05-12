package com.astontech.hr.services.Impl;

import com.astontech.hr.domain.User;
import com.astontech.hr.repositories.UserRepository;
import com.astontech.hr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Bipin on 5/12/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Iterable<User> listAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Iterable<User> saveUserList(Iterable<User> userIterable) {
        return userRepository.save(userIterable);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }
}
