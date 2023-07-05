package com.example.tp_demodto.service;

import com.example.tp_demodto.dto.PostCreateDto;
import com.example.tp_demodto.dto.PostDto;
import com.example.tp_demodto.dto.PostReadDto;

public interface PostServiceMapper {

     PostReadDto createPost(PostCreateDto postDto);
     PostDto readPost(Integer id);

    PostDto updatePost(Integer id, PostCreateDto postCreateDto);

    PostDto deletePost(Integer id);
}
