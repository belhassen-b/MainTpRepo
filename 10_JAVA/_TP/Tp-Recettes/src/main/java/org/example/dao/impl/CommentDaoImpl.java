package org.example.dao.impl;

import org.example.config.DataBaseSingleton;
import org.example.dao.ICommentDao;
import org.example.entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CommentDaoImpl implements ICommentDao<Comment> {


    private Connection connection;

    public CommentDaoImpl() {
        this.connection = DataBaseSingleton.getInstance().getConnection();
    }
    @Override
    public Comment save(Comment type) {
        String request = "INSERT INTO recettes.comment (idRecipe, content) VALUES (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setInt(1, type.getIdRecipe());
            statement.setString(2, type.getContent());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                return Comment.builder()
                        .idComment(generatedKeys.getInt(1))
                        .idRecipe(type.getIdRecipe())
                        .content(type.getContent())
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }

    @Override
    public Comment findById(int id) {
        String request = "SELECT * FROM recettes.comment WHERE idComment = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return Comment.builder()
                        .idComment(resultSet.getInt("idComment"))
                        .idRecipe(resultSet.getInt("idRecipe"))
                        .content(resultSet.getString("content"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(int id) {
        String request = "DELETE FROM recettes.comment WHERE idComment = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Comment> findAll() {
        List<Comment> comments = new ArrayList<>();
        String request = "SELECT * FROM recettes.comment";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
      comments.add(Comment.builder()
                        .idComment(resultSet.getInt("idComment"))
                        .idRecipe(resultSet.getInt("idRecipe"))
                        .content(resultSet.getString("content"))
                        .build());
            }
            return comments;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Comment update(Comment type) {
        String request = "UPDATE recettes.comment SET content = ?  WHERE idComment = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setString(1, type.getContent());
            statement.setInt(2, type.getIdComment());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                type.setIdComment(generatedKeys.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return type;
    }
}
