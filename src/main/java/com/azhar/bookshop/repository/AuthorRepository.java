package com.azhar.bookshop.repository;

import com.azhar.bookshop.model.Author;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author,String> {
    List<Author> findByName(String name);
    @Query("{'name': {$regex: ?0, $options: 'i'} }")
    List<Author> findByRegex(String text);
}
