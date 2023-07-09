package com.example.spring_tp_vendredi_07072023.service;

import com.example.spring_tp_vendredi_07072023.Dto.PostDto;

import java.util.List;

public interface IPostService {
    PostDto create(PostDto postDto);

    PostDto update(Long id, PostDto postDto);

    List<PostDto> findAll();


    PostDto findById(Long id);

    PostDto deleteById(Long id);
}
