package com.example.bookservice.controller;



import com.example.bookservice.dto.BookRequestDTO;
import com.example.bookservice.dto.BookResponseDTO;
import com.example.bookservice.entity.Book;
import com.example.bookservice.service.BookService;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/")
    public ResponseEntity<Book> post(@RequestBody BookRequestDTO bookRequestDTO) {
        System.out.println("coucou");
        Book book = bookService.createBook(bookRequestDTO.getTitle(),bookRequestDTO.getIsbn(), bookRequestDTO.getPublishDate(),  bookRequestDTO.getAuthorId());
        return ResponseEntity.ok(book);
    }


    @GetMapping("{authorId}")
    public ResponseEntity<BookResponseDTO> get(@PathVariable Long authorId) {
        return ResponseEntity.ok(bookService.getBookByAuthorId(authorId));
    }
}
