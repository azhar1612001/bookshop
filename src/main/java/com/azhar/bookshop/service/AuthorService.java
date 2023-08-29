package com.azhar.bookshop.service;

import com.azhar.bookshop.model.Author;
import com.azhar.bookshop.model.Book;

import java.util.List;

public interface AuthorService {
    Author addAuthor(Author author);
    List<Book> findByAuthor(String name);
    List<Author> findByAuthorRegex(String text);
}
