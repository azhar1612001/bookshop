package com.azhar.bookshop.service;

import com.azhar.bookshop.model.Book;
import com.azhar.bookshop.repository.BookRepository;
import com.azhar.bookshop.repository.GenreCopyAvailable;
import com.azhar.bookshop.repository.GenreSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Service
public class BookServiceImplementation implements BookService{
    @Autowired
    BookRepository bookRepo;
    @Autowired
    GenreSearchRepository genreRepo;
    @Autowired
    GenreCopyAvailable genCopyRepo;
    @Override
    public List<Book> getAllBook(){
        return bookRepo.findAll();
    }
    @Override
    public Book addBook(Book book){
        return bookRepo.insert(book);
    }
    @Override
    public List<Book> findByGenre(String genre){
        return genreRepo.findByGenre(genre);
    }
    @Override
    public List<Book> findByParams(String genre,Integer copyAvailable){
        return genCopyRepo.findByParams(genre,copyAvailable);
    }
}
