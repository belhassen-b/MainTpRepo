package com.example.demo_rest.repository;


import com.example.demo_rest.entity.ListTodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ListTodoItemRepository extends JpaRepository<ListTodoItem, Integer> {
}
