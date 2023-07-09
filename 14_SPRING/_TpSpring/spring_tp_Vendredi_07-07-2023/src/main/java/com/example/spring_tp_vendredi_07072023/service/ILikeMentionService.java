package com.example.spring_tp_vendredi_07072023.service;


import com.example.spring_tp_vendredi_07072023.Dto.LikeMentionDto;

import java.util.List;

public interface ILikeMentionService {

    LikeMentionDto create(LikeMentionDto likeMentionDto);

    LikeMentionDto update(Long id, LikeMentionDto likeMentionDto);

    LikeMentionDto findById(Long id);

    LikeMentionDto deleteById(Long id);

    List<LikeMentionDto> findAll();
}


