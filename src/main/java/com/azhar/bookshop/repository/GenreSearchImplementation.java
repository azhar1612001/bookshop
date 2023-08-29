package com.azhar.bookshop.repository;

import com.azhar.bookshop.model.Book;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class GenreSearchImplementation implements GenreSearchRepository{
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Book> findByGenre(String text){
        final List<Book> books = new ArrayList<>();

        MongoDatabase database = client.getDatabase("bookstore");
        MongoCollection<Document> collection = database.getCollection("Book");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("index", "default")
                        .append("text",
                                new Document("query", text)
                                        .append("path", "genre")))));
        result.forEach(doc -> books.add(converter.read(Book.class, doc)));

        return books;
    }
}
