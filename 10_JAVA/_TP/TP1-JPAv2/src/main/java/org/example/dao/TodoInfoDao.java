package org.example.dao;

import org.example.model.TodoInfo;

import java.util.List;

public interface TodoInfoDao {

    public boolean create(TodoInfo todoInfo);

    public List<TodoInfo> getAll();

    public boolean update(TodoInfo todoInfo);

    public boolean delete(TodoInfo todoInfo);

}
