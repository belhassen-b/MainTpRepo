package com.example.tp_demodto.utils;

import com.example.tp_demodto.dto.CommentDto;
import com.example.tp_demodto.dto.PostDto;
import com.example.tp_demodto.entity.Comment;
import com.example.tp_demodto.entity.Post;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoUtils {


    public PostDto convertToDto(Post post, PostDto postDto) {
        return new ModelMapper().map(post, postDto.getClass());
    }

    public Post convertToEntity(Post post, PostDto postDto) {
        return new ModelMapper().map(postDto, post.getClass());
    }

    public CommentDto convertToDto(Comment comment, CommentDto commentDto) {
        return new ModelMapper().map(comment, commentDto.getClass());
    }

    public Comment convertToEntity(Comment comment, CommentDto commentDto) {
        return new ModelMapper().map(commentDto, comment.getClass());
    }

}
