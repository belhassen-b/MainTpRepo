package com.example.spring_api_validation.repository;

import com.example.spring_api_validation.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository  extends JpaRepository<Author, Integer> {
}