package com.example.tp1spring.service.impl;


import com.example.tp1spring.entity.User;
import com.example.tp1spring.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements com.example.tp1spring.service.IUserService{

private final UserRepository _userRepository;

public UserServiceImpl(UserRepository userRepository) {
    _userRepository = userRepository;
}

    @Override
    public boolean create(User u) {
        _userRepository.save(u);
        return  u.getId() > 0;
    }
    @Override
    public boolean update(User u) {
_userRepository.save(u);
        return true;    }

    @Override
    public boolean delete(User u) {
        _userRepository.delete(u);
        return true;
    }
    @Override
    public User findById(int id) {
    _userRepository.findById(id).get();
    return _userRepository.findById(id).get();
}
    @Override
    public List<User> findAll() {
        return (List<User>) _userRepository.findAll();
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return _userRepository.findByUsernameAndPassword(username, password);
    }


}
