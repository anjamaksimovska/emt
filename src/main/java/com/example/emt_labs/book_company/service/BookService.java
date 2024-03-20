package com.example.emt_labs.book_company.service;

import com.example.emt_labs.book_company.model.Book;

import java.util.List;

public interface BookService {

    Book addBook(Book book);

    void deleteBook(Long id);

    Book updateBook(Long id, Book book);

    Book markBookAsRented(Long id);

    List<Book> getAllBooks();
}
