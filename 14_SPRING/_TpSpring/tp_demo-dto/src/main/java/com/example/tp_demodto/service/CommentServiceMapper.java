package com.example.tp_demodto.service;

import com.example.tp_demodto.dto.*;

public interface CommentServiceMapper {
    CommentReadDto createComment(CommentCreateDto commentDto);
    CommentDto readComment(Integer id);

    CommentDto updateComment(Integer id, CommentCreateDto commentCreateDto);

    CommentDto deleteComment(Integer id);

    CommentDto readCommentByPost(Integer id);
}
