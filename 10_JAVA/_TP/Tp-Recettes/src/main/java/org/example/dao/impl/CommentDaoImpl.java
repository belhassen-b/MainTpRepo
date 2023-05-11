package org.example.dao.impl;

import org.example.dao.IGenericDao;
import org.example.entity.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

public class CommentDaoImpl implements IGenericDao<Comment> {


    private Connection connection;

    public CommentDaoImpl() {

        this.connection = connection;
    }
    @Override
    public Comment save(Comment type) {
        String request = "INSERT INTO recettes.comment (idRecipe, comment, comment) VALUES (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setInt(1, type.getIdRecipe());
            statement.setString(2, type.getContent());
            statement.setInt(3, type.getIdRecipe());
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
        String request = "SELECT * FROM recettes.comment";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                return List.of(Comment.builder()
                        .idComment(resultSet.getInt("idComment"))
                        .idRecipe(resultSet.getInt("idRecipe"))
                        .content(resultSet.getString("content"))
                        .build());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Comment update(Comment type) {
        String request = "UPDATE recettes.comment SET idRecipe = ?, comment = ? WHERE idComment = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(request, RETURN_GENERATED_KEYS);
            statement.setInt(1, type.getIdRecipe());
            statement.setString(2, type.getContent());
            statement.setInt(3, type.getIdComment());
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
