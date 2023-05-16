package org.example.dao;

import org.example.model.Todo;

import java.util.List;

public interface TodoDao {

    public boolean create(Todo todo);

    public List<Todo> getAll();

    public boolean update(Todo todo);

    public boolean delete(Todo todo);

    public Todo getById(Long id);

    boolean setAchieved(Long id);
}
