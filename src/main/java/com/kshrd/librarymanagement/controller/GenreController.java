package com.kshrd.librarymanagement.controller;

import com.kshrd.librarymanagement.model.Genre;
import com.kshrd.librarymanagement.model.request.GenreRequest;
import com.kshrd.librarymanagement.model.response.ApiResponse;
import com.kshrd.librarymanagement.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/genres")
@RequiredArgsConstructor
public class GenreController {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Genre>>> getAllGenres() {
        ApiResponse<List<Genre>> response = ApiResponse.<List<Genre>>builder()
                .message("Get all genres successfully")
                .status(HttpStatus.OK)
                .payload(genreService.getAllGenres())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Genre>> getGenre(@PathVariable Long id) {
        ApiResponse<Genre> response = ApiResponse.<Genre>builder()
                .message("Get genre successfully")
                .status(HttpStatus.OK)
                .payload(genreService.getGenre(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Genre>> createGenre(@RequestBody GenreRequest GenreRequest) {
        ApiResponse<Genre> response = ApiResponse.<Genre>builder()
                .message("Create genre successfully")
                .status(HttpStatus.CREATED)
                .payload(genreService.createGenre(GenreRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Genre>> updateGenre(@PathVariable Long id, @RequestBody GenreRequest GenreRequest) {
        ApiResponse<Genre> response = ApiResponse.<Genre>builder()
                .message("Update genre successfully")
                .status(HttpStatus.OK)
                .payload(genreService.updateGenre(id, GenreRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Genre>> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        ApiResponse<Genre> response = ApiResponse.<Genre>builder()
                .message("Delete genre successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

}
