package com.example.demo_rest.service;


import com.example.demo_rest.entity.TodoItem;
import com.example.demo_rest.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public void createTodoItem(TodoItem todoItem) {
        todoItemRepository.save(todoItem);
    }

    public Optional<TodoItem> getTodoItemById(Integer id) {
        return todoItemRepository.findById(id);
    }

    public void updateTodoItem(Integer id, TodoItem todoItem) {
        todoItem.setId(id);
        todoItemRepository.save(todoItem);
    }

    public Object getAll() {
        return todoItemRepository.findAll();
    }

    public void deleteTodoItem(Integer id) {
        todoItemRepository.deleteById(id);
    }
}