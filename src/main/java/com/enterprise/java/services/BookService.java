package com.enterprise.java.services;

import com.enterprise.java.models.Book;
import com.enterprise.java.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    
    // Define book repository interaction methods

    public void createOrUpdateBook(Book book){
        bookRepository.save(book);
    }

    public Optional<Book> getBookById(int bookId){
        return bookRepository.findById(bookId);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteBookById(int bookId){
        bookRepository.deleteById(bookId);
    }
}
