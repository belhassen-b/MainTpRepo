package com.example.tp_demodto.service.impl;

import com.example.tp_demodto.dto.CommentCreateDto;
import com.example.tp_demodto.dto.CommentDto;
import com.example.tp_demodto.dto.CommentReadDto;
import com.example.tp_demodto.entity.Comment;
import com.example.tp_demodto.repository.CommentRepository;
import com.example.tp_demodto.service.CommentServiceMapper;
import com.example.tp_demodto.utils.DtoUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CommentServiceImpl implements CommentServiceMapper {

    @Autowired
    private DtoUtils dtoUtils;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public CommentReadDto createComment(CommentCreateDto commentDto) {

            Comment comment = dtoUtils.convertToEntity(new Comment(), commentDto);

            Comment comment1 = commentRepository.save(comment);

            return (CommentReadDto) dtoUtils.convertToDto(comment1, new CommentReadDto());

    }

    @Override
    public CommentDto readComment(Integer id) {
        return dtoUtils.convertToDto(commentRepository.findById(id).get(), new CommentReadDto());
    }

    @Override
    public CommentDto updateComment(Integer id, CommentCreateDto commentCreateDto) {
        Comment comment = commentRepository.findById(id).get();
        comment.setBody(commentCreateDto.getBody());
        comment.setEmail(commentCreateDto.getEmail());
        comment.setName(commentCreateDto.getName());

        Comment comment1 = commentRepository.save(comment);
        return dtoUtils.convertToDto(comment1, new CommentReadDto());
    }

    @Override
    public CommentDto deleteComment(Integer id) {
        Comment comment = new Comment();
        if (commentRepository.findById(id).isPresent()) {
            comment = commentRepository.findById(id).get();
            commentRepository.delete(comment);

        }
        return dtoUtils.convertToDto(comment, new CommentReadDto());
    }

    @Override
    public CommentDto readCommentByPost(Integer id) {
        return dtoUtils.convertToDto(commentRepository.findById(id).get(), new CommentReadDto());
    }


}
