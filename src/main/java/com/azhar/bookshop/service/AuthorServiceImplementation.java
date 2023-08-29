package com.azhar.bookshop.service;

import com.azhar.bookshop.model.Author;
import com.azhar.bookshop.model.Book;
import com.azhar.bookshop.repository.AuthorRepository;
import com.azhar.bookshop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
@Service
public class AuthorServiceImplementation implements AuthorService{
    @Autowired
    AuthorRepository authRepo;
    @Autowired
    BookRepository bookRepo;
    @Override
    public Author addAuthor(Author author){
        return authRepo.save(author);
    }
    @Override
    public List<Book> findByAuthor(String name){
        List<Author> authors = authRepo.findByName(name);
        List<Book> books = new ArrayList<>();
        for(Author author : authors){
            books.addAll(bookRepo.findByAuthorId(author.getId()));
        }
        return books;
    }
    @Override
    public List<Author> findByAuthorRegex(String text){
        return authRepo.findByRegex(text);
    }
}
