package com.example.spring_tp_vendredi_07072023.service;


import com.example.spring_tp_vendredi_07072023.Dto.UserCreateDto;
import com.example.spring_tp_vendredi_07072023.Dto.UserReadDto;

import java.util.List;

public interface IUserService {
    UserReadDto findById(Long id);
    List<UserReadDto> findAll();
    UserCreateDto create(UserCreateDto userCreateDto);
    boolean getUserById(Long id);
    UserReadDto create(UserReadDto userReadDto);
    UserCreateDto update(Long id, UserCreateDto userCreateDto);

    UserReadDto deleteById(Long id);
}
