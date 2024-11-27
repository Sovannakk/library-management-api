package com.kshrd.librarymanagement.service.impl;

import com.kshrd.librarymanagement.model.Author;
import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.Borrower;
import com.kshrd.librarymanagement.model.Genre;
import com.kshrd.librarymanagement.model.request.BookRequest;
import com.kshrd.librarymanagement.repository.AuthorRepository;
import com.kshrd.librarymanagement.repository.BookRepository;
import com.kshrd.librarymanagement.repository.BorrowerRepository;
import com.kshrd.librarymanagement.repository.GenreRepository;
import com.kshrd.librarymanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final BorrowerRepository borrowerRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book createBook(BookRequest bookRequest) {
        Author author = authorRepository.findById(bookRequest.getAuthorId()).orElse(null);
        Genre genre = genreRepository.findById(bookRequest.getGenreId()).orElse(null);
        return bookRepository.save(bookRequest.toEntity(author, genre));
    }

    @Override
    public Book updateBook(Long id, Boolean availability) {
        Book book = bookRepository.findById(id).orElse(null);
        assert book != null;
        book.setAvailability(availability);
        return bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBooksByGenre(Long genreId) {
        return bookRepository.findAllByGenreId(genreId);
    }

    @Override
    public List<Book> getAllBooksByAuthor(Long authorId) {
        return bookRepository.findAllByAuthorId(authorId);
    }

    @Override
    public List<Book> getAllBooksAvailable() {
        return bookRepository.findAllByAvailability(true);
    }

    @Override
    public void borrowBook(Long id, Long borrowerId) {
        Book book = bookRepository.findById(id).orElse(null);
        assert book != null;
        Borrower borrower = borrowerRepository.findById(borrowerId).orElse(null);
        book.getBorrowers().add(borrower);
        bookRepository.save(book);
    }
}
