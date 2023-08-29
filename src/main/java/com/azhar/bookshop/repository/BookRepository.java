package com.azhar.bookshop.repository;

import com.azhar.bookshop.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book,String> {
    List<Book> findByAuthorId(int authorId);
}
