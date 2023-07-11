package com.example.react_api.service;

import com.example.react_api.dto.DepartementDto;

import java.util.List;

public interface IDepartementService {
    DepartementDto create(DepartementDto departementDto);

    List<DepartementDto> findAll();

    DepartementDto findById(Long id);

    DepartementDto update(Long id, DepartementDto departementDto);

    DepartementDto deleteById(Long id);
}
