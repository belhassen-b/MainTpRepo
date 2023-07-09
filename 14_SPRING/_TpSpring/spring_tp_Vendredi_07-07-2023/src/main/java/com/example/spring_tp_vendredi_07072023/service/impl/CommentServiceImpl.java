package com.example.spring_tp_vendredi_07072023.service.impl;


import com.example.spring_tp_vendredi_07072023.Dto.CommentDto;
import com.example.spring_tp_vendredi_07072023.entity.Comment;
import com.example.spring_tp_vendredi_07072023.repository.ICommentRepository;
import com.example.spring_tp_vendredi_07072023.service.ICommentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements ICommentService {

    private final ICommentRepository commentRepository;
    private final ModelMapper modelMapper;


    @Override
    public CommentDto deleteById(Long id) {
        Comment comment = commentRepository.findById(id).get();
        commentRepository.delete(comment);
        return modelMapper.map(commentRepository.save(comment), CommentDto.class);
    }

    @Override
    public CommentDto update(Long id, CommentDto commentDto) {
        Comment comment1 = commentRepository.findById(id).get();
        comment1.setMessage(commentDto.getMessage());
        comment1.setLikeMentions(commentDto.getLikeMentions());
        comment1.setDislikeMentions(commentDto.getDislikeMentions());
        comment1.setPost(commentDto.getPost());
        return modelMapper.map(commentRepository.save(comment1), CommentDto.class);
    }

    @Override
    public CommentDto create(CommentDto commentDto) {
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return modelMapper.map(commentRepository.save(comment), CommentDto.class);
    }

    @Override
    public CommentDto findById(Long id) {
        return modelMapper.map(commentRepository.findById(id).get(), CommentDto.class);
    }

    @Override
    public List<CommentDto> findAll() {
        List<Comment> comments = commentRepository.findAll();
        return comments.stream().map(comment -> modelMapper.map(comment, CommentDto.class)).collect(java.util.stream.Collectors.toList());
    }
}
