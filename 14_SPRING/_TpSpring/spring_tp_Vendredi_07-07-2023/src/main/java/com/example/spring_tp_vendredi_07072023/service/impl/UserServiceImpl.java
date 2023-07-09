package com.example.spring_tp_vendredi_07072023.service.impl;


import com.example.spring_tp_vendredi_07072023.Dto.UserCreateDto;
import com.example.spring_tp_vendredi_07072023.Dto.UserReadDto;
import com.example.spring_tp_vendredi_07072023.entity.User;
import com.example.spring_tp_vendredi_07072023.repository.IUserRepository;
import com.example.spring_tp_vendredi_07072023.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl  implements IUserService {

    private final IUserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserReadDto findById(Long id) {
        User user = userRepository.findById(id).get();
        return modelMapper.map(user, UserReadDto.class);

    }

    @Override
    public List<UserReadDto> findAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserReadDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserCreateDto create(UserCreateDto userCreateDto) {
        User user = modelMapper.map(userCreateDto, User.class);
        return modelMapper.map(userRepository.save(user), UserCreateDto.class);
    }

    @Override
    public boolean getUserById(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public UserReadDto create(UserReadDto userReadDto) {
        User user = modelMapper.map(userReadDto, User.class);
        return modelMapper.map(userRepository.save(user), UserReadDto.class);
    }

    @Override
    public UserCreateDto update(Long id, UserCreateDto userCreateDto) {
        User user1 = userRepository.findById(id).get();
        user1.setName(userCreateDto.getName());
        user1.setPassword(userCreateDto.getPassword());
        return modelMapper.map(userRepository.save(user1), UserCreateDto.class);
    }

    @Override
    public UserReadDto deleteById(Long id) {
        User user = userRepository.findById(id).get();
        userRepository.delete(user);
        return modelMapper.map(user, UserReadDto.class);
    }
}
