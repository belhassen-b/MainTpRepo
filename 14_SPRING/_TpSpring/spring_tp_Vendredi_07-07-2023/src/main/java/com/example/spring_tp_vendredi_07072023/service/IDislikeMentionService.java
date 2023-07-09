package com.example.spring_tp_vendredi_07072023.service;

import com.example.spring_tp_vendredi_07072023.Dto.DislikeMentionDto;

import java.util.List;

public interface IDislikeMentionService {
   DislikeMentionDto create(DislikeMentionDto dislikeMentionDto);

    DislikeMentionDto update(Long id, DislikeMentionDto dislikeMentionDto);

    DislikeMentionDto findById(Long id);

    DislikeMentionDto deleteById(Long id);

    List<DislikeMentionDto> findAll();
}
