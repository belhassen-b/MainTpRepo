package org.example.service;

import org.example.entity.Comment;

import java.sql.SQLException;
import java.util.List;

public interface ICommentService {

    Comment create(Comment comment);

    void delete(int id) throws SQLException;

    List<Comment> findAll();

    Comment findById(int id);

    Comment update(Comment comment) throws SQLException;


}
