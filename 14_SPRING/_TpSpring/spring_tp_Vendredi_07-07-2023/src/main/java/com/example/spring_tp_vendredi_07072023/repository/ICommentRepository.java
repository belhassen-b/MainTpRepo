package com.example.spring_tp_vendredi_07072023.repository;

import com.example.spring_tp_vendredi_07072023.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ICommentRepository extends JpaRepository<Comment, Long> {
}
