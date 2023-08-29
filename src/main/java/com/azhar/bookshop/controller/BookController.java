package com.azhar.bookshop.controller;

import com.azhar.bookshop.model.Book;
import com.azhar.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookService.getAllBook();
    }

    @PostMapping("/book")
    public ResponseEntity<?> addBook(@RequestBody @Valid Book book){
        Book save = bookService.addBook(book);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/book/{text}")
    public List<Book> findByGenre(@PathVariable String text){
        return bookService.findByGenre(text);
    }

    @GetMapping("/book/{genre}/{copyAvailable}")
    public List<Book> findByParams(@PathVariable String genre,@PathVariable Integer copyAvailable){
        return bookService.findByParams(genre,copyAvailable);
    }
}
