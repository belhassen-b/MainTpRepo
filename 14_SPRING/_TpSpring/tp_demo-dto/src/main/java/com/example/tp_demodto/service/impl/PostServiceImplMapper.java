package com.example.tp_demodto.service.impl;

import com.example.tp_demodto.dto.PostCreateDto;
import com.example.tp_demodto.dto.PostDto;
import com.example.tp_demodto.dto.PostReadDto;
import com.example.tp_demodto.entity.Post;
import com.example.tp_demodto.repository.PostRepository;
import com.example.tp_demodto.service.PostServiceMapper;
import com.example.tp_demodto.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PostServiceImplMapper implements PostServiceMapper {


    @Autowired
    private DtoUtils dtoUtils;

    @Autowired
    private PostRepository postRepository;


    @Override
    public PostReadDto createPost(PostCreateDto postDto) {
        Post post = dtoUtils.convertToEntity(new Post(), postDto);
        Post post1 = postRepository.save(post);
        return (PostReadDto) dtoUtils.convertToDto(post1, new PostReadDto());
    }

    @Override
    public PostDto readPost(Integer id) {
        return dtoUtils.convertToDto(postRepository.findById(id).get(), new PostReadDto());
    }

    @Override
    public PostDto updatePost(Integer id, PostCreateDto postCreateDto) {
        Post post = postRepository.findById(id).get();
        post.setTitle(postCreateDto.getTitle());
        post.setContent(postCreateDto.getContent());
        post.setDescription(postCreateDto.getDescription());
        Post post1 = postRepository.save(post);
        return dtoUtils.convertToDto(post1, new PostReadDto());

    }

    @Override
    public PostDto deletePost(Integer id) {
        Post post = new Post();
        if (postRepository.findById(id).isPresent()) {
            post = postRepository.findById(id).get();
            postRepository.delete(post);

        }
        return dtoUtils.convertToDto(post, new PostReadDto());
    }
}