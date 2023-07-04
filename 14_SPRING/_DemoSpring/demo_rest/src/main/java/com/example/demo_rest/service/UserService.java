package com.example.demo_rest.service;


import com.example.demo_rest.entity.User;
import com.example.demo_rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user) {
        return userRepository.save(user);
    }

    public boolean getUserEmail(String email) {
        User user = userRepository.findUserByEmail(email);
        return user != null ? true : false;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    public     User getUserById(Integer id) {
        return userRepository.findById(id).get();
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateUser(Integer id, User user) {
        userRepository.save(user);
    }

    public void isPresent(Integer id) {
        userRepository.existsById(id);
    }
}
