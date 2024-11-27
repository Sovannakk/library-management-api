package com.kshrd.librarymanagement.service;

import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.request.BookRequest;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBook(Long id);

    Book createBook(BookRequest bookRequest);

    Book updateBook(Long id, Boolean availability);

    void deleteBook(Long id);

    List<Book> getAllBooksByGenre(Long genreId);

    List<Book> getAllBooksByAuthor(Long authorId);

    List<Book> getAllBooksAvailable();

    void borrowBook(Long id, Long borrowerId);
}
