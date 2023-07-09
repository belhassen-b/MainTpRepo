package com.example.spring_tp_vendredi_07072023.service.impl;


import com.example.spring_tp_vendredi_07072023.Dto.PostDto;
import com.example.spring_tp_vendredi_07072023.entity.Post;
import com.example.spring_tp_vendredi_07072023.repository.IPostRepository;
import com.example.spring_tp_vendredi_07072023.service.IPostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements IPostService {

    private final IPostRepository   postRepository;
    private final ModelMapper modelMapper;



    @Override
    public PostDto create(PostDto postDto) {
    Post post = modelMapper.map(postDto, Post.class);
    return modelMapper.map(postRepository.save(post), PostDto.class);

    }

    @Override
    public PostDto update(Long id, PostDto postDto) {
        Post post1 = postRepository.findById(id).get();
        post1.setTitle(postDto.getTitle());
        post1.setBody(postDto.getBody());
        post1.setComments(postDto.getComments());
        post1.setUser(postDto.getUser());
        return modelMapper.map(postRepository.save(post1), PostDto.class);
    }

    @Override
    public List<PostDto> findAll() {
        List<Post> posts = postRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostDto findById(Long id) {
        return modelMapper.map(postRepository.findById(id).get(), PostDto.class);
    }

    @Override
    public PostDto deleteById(Long id) {
    Post post = postRepository.findById(id).get();
    postRepository.delete(post);
    return modelMapper.map(postRepository.save(post), PostDto.class);
    }
}

