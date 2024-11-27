package com.kshrd.librarymanagement.controller;

import com.kshrd.librarymanagement.model.Author;
import com.kshrd.librarymanagement.model.request.AuthorRequest;
import com.kshrd.librarymanagement.model.response.ApiResponse;
import com.kshrd.librarymanagement.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Author>>> getAllAuthors() {
        ApiResponse<List<Author>> response = ApiResponse.<List<Author>>builder()
                .message("Get all authors successfully")
                .status(HttpStatus.OK)
                .payload(authorService.getAllAuthors())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Author>> getAuthor(@PathVariable Long id) {
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Get author successfully")
                .status(HttpStatus.OK)
                .payload(authorService.getAuthor(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Author>> createAuthor(@RequestBody AuthorRequest authorRequest) {
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Create author successfully")
                .status(HttpStatus.CREATED)
                .payload(authorService.createAuthor(authorRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Author>> updateAuthor(@PathVariable Long id, @RequestBody AuthorRequest authorRequest) {
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Update author successfully")
                .status(HttpStatus.OK)
                .payload(authorService.updateAuthor(id, authorRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Author>> deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
        ApiResponse<Author> response = ApiResponse.<Author>builder()
                .message("Delete author successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

}
