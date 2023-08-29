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
public class GenreCopyAvailableImplemtation implements GenreCopyAvailable{
    @Autowired
    MongoClient client;
    @Autowired
    MongoConverter converter;
    @Override
    public List<Book> findByParams(String genre,Integer copyAvailable){
        final List<Book> books = new ArrayList<>();
        MongoDatabase database = client.getDatabase("bookstore");
        MongoCollection<Document> collection = database.getCollection("Book");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", genre)
                                                .append("path", "genre"))),
                new Document("$match",
                        new Document("copiesAvailable",
                                new Document("$gt", copyAvailable)))));
        result.forEach(doc -> books.add(converter.read(Book.class, doc)));
        return books;
    }

}
