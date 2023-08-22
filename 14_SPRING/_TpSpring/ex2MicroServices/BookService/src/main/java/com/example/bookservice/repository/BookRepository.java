package com.example.bookservice.repository;


import com.example.bookservice.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthorId(Long authorId);

    List<Book> findAllByBookId(Long bookId);
}
