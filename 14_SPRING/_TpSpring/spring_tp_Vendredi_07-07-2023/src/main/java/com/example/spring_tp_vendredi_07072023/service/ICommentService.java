package com.example.spring_tp_vendredi_07072023.service;

import com.example.spring_tp_vendredi_07072023.Dto.CommentDto;

import java.util.List;

public interface ICommentService {
    CommentDto deleteById(Long id);

    CommentDto update(Long id, CommentDto commentDto);

    CommentDto create(CommentDto commentDto) throws Exception;

    CommentDto findById(Long id);

    List<CommentDto> findAll();
}
