package com.example.tp_demodto.repository;

import com.example.tp_demodto.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
