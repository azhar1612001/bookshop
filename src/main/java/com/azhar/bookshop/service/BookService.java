package com.azhar.bookshop.service;

import com.azhar.bookshop.model.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBook();
    Book addBook(Book book);
    List<Book> findByGenre(String name);
    List<Book> findByParams(String genre,Integer copyAvailable);
}
