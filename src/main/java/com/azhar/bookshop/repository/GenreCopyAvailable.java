package com.azhar.bookshop.repository;

import com.azhar.bookshop.model.Book;

import java.util.List;

public interface GenreCopyAvailable{
    List<Book> findByParams(String genre, Integer copyAvailable);
}
