package com.azhar.bookshop.controller;

import com.azhar.bookshop.model.Author;
import com.azhar.bookshop.model.Book;
import com.azhar.bookshop.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class AuthorController {
    @Autowired
    AuthorService authService;
    @PostMapping("/author")
    public ResponseEntity<?> addAuthor(@RequestBody Author author){
        Author save = authService.addAuthor(author);
        return ResponseEntity.ok(save);
    }

    @GetMapping("/author/{name}")
    List<Book> findByAuthor(@PathVariable String name){
        return authService.findByAuthor(name);
    }
    @GetMapping("/author/search/{text}")
    List<Author> findByAuthorRegex(@PathVariable String text){
        return authService.findByAuthorRegex(text);
    }
}
