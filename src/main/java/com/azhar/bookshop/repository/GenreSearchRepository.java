package com.azhar.bookshop.repository;

import com.azhar.bookshop.model.Book;

import java.util.List;

public interface GenreSearchRepository {
    List<Book> findByGenre(String text);
}
