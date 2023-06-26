package com.example.tp1spring.repository;


import com.example.tp1spring.entity.Category;
import com.example.tp1spring.entity.Priority;
import com.example.tp1spring.entity.Todo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo,Integer> {

    public List<Category> findAllByCategory(String search);

    public List<Priority> findAllByPriority(String search);
}
