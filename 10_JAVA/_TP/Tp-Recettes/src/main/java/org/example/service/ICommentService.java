package org.example.service;

import org.example.entity.Comment;

import java.util.List;

public interface ICommentService {

    Comment create(Comment comment);

    Comment delete(int id);

    List<Comment> findAll();

    Comment findById(int id);

    Comment update(Comment comment);


}
