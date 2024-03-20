package com.example.emt_labs.book_company.service;

import com.example.emt_labs.book_company.model.Book;
import com.example.emt_labs.book_company.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBook(Long id, Book book) {
        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        existingBook.setName(book.getName());
        existingBook.setCategory(book.getCategory());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setAvailableCopies(book.getAvailableCopies());

        return bookRepository.save(existingBook);
    }

    @Override
    public Book markBookAsRented(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));

        int availableCopies = book.getAvailableCopies();
        if (availableCopies > 0) {
            book.setAvailableCopies(availableCopies - 1);
        } else {
            // Handle when there are no available copies
            // For example, throw an exception or return a specific response
        }

        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}

