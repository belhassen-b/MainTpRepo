package com.example.spring_api_validation.repository;


import com.example.spring_api_validation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository  extends JpaRepository<Book, Integer> {
}