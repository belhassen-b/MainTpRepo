package com.example.demo_rest.repository;


import com.example.demo_rest.entity.TodoItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepository extends CrudRepository<TodoItem, Integer> {



}
