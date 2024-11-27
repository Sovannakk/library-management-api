package com.kshrd.librarymanagement.controller;

import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.request.BookRequest;
import com.kshrd.librarymanagement.model.response.ApiResponse;
import com.kshrd.librarymanagement.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooks() {
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("Get all books successfully")
                .status(HttpStatus.OK)
                .payload(bookService.getAllBooks())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> getBook(@PathVariable Long id) {
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Get book successfully")
                .status(HttpStatus.OK)
                .payload(bookService.getBook(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Book>> createBook(@RequestBody BookRequest BookRequest) {
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Create book successfully")
                .status(HttpStatus.CREATED)
                .payload(bookService.createBook(BookRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@PathVariable Long id, @RequestParam(defaultValue = "false") Boolean availability) {
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Update book successfully")
                .status(HttpStatus.OK)
                .payload(bookService.updateBook(id, availability))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Book>> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Delete book successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooksByGenre(@PathVariable Long genreId) {
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("Get all books by genre successfully")
                .status(HttpStatus.OK)
                .payload(bookService.getAllBooksByGenre(genreId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooksByAuthor(@PathVariable Long authorId) {
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("Get all books by author successfully")
                .status(HttpStatus.OK)
                .payload(bookService.getAllBooksByAuthor(authorId))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/available")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBooksAvailable() {
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("Get all books available successfully")
                .status(HttpStatus.OK)
                .payload(bookService.getAllBooksAvailable())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/borrow/{borrowerId}")
    public ResponseEntity<ApiResponse<Book>> borrowBook(@PathVariable Long id, @PathVariable Long borrowerId) {
        bookService.borrowBook(id, borrowerId);
        ApiResponse<Book> response = ApiResponse.<Book>builder()
                .message("Borrow book successfully")
                .status(HttpStatus.CREATED)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

}
