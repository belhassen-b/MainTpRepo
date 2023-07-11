package com.example.react_api.service.impl;


import com.example.react_api.dto.DepartementDto;
import com.example.react_api.entity.Departement;
import com.example.react_api.repository.IDepartementRepository;
import com.example.react_api.service.IDepartementService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartementServiceImpl implements IDepartementService {

    private final ModelMapper modelMapper;
    private final IDepartementRepository departementRepository;


    @Override
    public DepartementDto create(DepartementDto departementDto) {
        Departement departement = modelMapper.map(departementDto, Departement.class);
        return modelMapper.map(departementRepository.save(departement), DepartementDto.class);
    }

    @Override
    public List<DepartementDto> findAll() {
        List<Departement> departements = departementRepository.findAll();
        List<DepartementDto> list = modelMapper.map(departements, List.class);
        return list;
    }

    @Override
    public DepartementDto findById(Long id) {
        Departement departement = departementRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Departement not found")
        );
        return modelMapper.map(departement, DepartementDto.class);
    }

    public DepartementDto update(Long id, DepartementDto departementDto) {
        Departement departement = departementRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Departement not found")
        );
        departement.setDepartmentName(departementDto.getDepartmentName());
        departement.setDepartmentDescription(departementDto.getDepartmentDescription());
        return modelMapper.map(departementRepository.save(departement), DepartementDto.class);
    }

    @Override
    public DepartementDto deleteById(Long id) {
        Departement departement = departementRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Departement not found")
        );
        departementRepository.deleteById(id);
        return modelMapper.map(departement, DepartementDto.class);
    }

    public DepartementDto delete(Long id) {
        Departement departement = departementRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Departement not found")
        );
        departementRepository.delete(departement);
    return modelMapper.map(departement, DepartementDto.class);

    }
}
