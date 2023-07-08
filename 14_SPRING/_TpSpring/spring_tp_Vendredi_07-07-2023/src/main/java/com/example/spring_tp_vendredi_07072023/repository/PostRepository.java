package com.example.spring_tp_vendredi_07072023.repository;

import com.example.spring_tp_vendredi_07072023.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
