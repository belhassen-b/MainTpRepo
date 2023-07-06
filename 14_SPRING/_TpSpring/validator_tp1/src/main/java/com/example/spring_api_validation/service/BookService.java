package com.example.spring_api_validation.service;


import com.example.spring_api_validation.entity.Book;
import com.example.spring_api_validation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }

    public void deleteById(Integer id){
        bookRepository.deleteById(id);
    }

    public Book findById(Integer id){
        return bookRepository.findById(id).get();
    }

    public List<Book> findAll(){
        return bookRepository.findAll();
    }


    public Book updateBookById(Integer id, Book book) {
        Book book1 = bookRepository.findById(id).get();
        book1.setTitle(book.getTitle());
        book1.setAuthor(book.getAuthor());
        book1.setGenre(book.getGenre());
        book1.setYear(book.getYear());
        return bookRepository.save(book1);
    }
}
