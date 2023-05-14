package org.example.service.impl;

import org.example.dao.impl.CommentDaoImpl;
import org.example.entity.Comment;
import org.example.entity.Recipe;
import org.example.service.ICommentService;

import java.sql.SQLException;
import java.util.List;

public class CommentServiceImpl implements ICommentService {

    private CommentDaoImpl commentDao;

    public CommentServiceImpl() throws SQLException {
        this.commentDao = new CommentDaoImpl();
    }


    @Override
    public Comment create(Comment comment) {
        return commentDao.save(comment);
    }

    @Override
    public void delete(int id) throws SQLException {
        commentDao.delete(id);
    }

    @Override
    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    @Override
    public Comment findById(int id) {
        return commentDao.findById(id);
    }

    @Override
    public Comment update(Comment comment) throws SQLException{
        return commentDao.update(comment);
    }
}
