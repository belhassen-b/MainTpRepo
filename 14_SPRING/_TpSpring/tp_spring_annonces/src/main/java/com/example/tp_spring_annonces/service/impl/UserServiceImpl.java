package com.example.tp_spring_annonces.service.impl;

import com.example.tp_spring_annonces.entity.User;
import com.example.tp_spring_annonces.repository.UserRepository;
import com.example.tp_spring_annonces.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {
    private final UserRepository _userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        _userRepository = userRepository;
    }


    @Override
    public boolean save(User user) {
        _userRepository.save(user);
        return user.getId() > 0;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return _userRepository.findByEmailAndPassword(email, password);

    }

    @Override
    public List<User> findAll() {
        return  _userRepository.findAll();
    }

    @Override
    public boolean update(User user) {
        _userRepository.save(user);
        return true;
    }

    @Override
    public boolean deleteById(Long id) {
        _userRepository.deleteById(id);
        return true;
    }

    @Override
    public User findById(Long id) {
        return _userRepository.findById(id).get();
    }
}

