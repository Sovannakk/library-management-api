package com.kshrd.librarymanagement.model.request;

import com.kshrd.librarymanagement.model.Author;
import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String title;
    private String isbn;
    private Integer publicationYear;
    private Long authorId;
    private Long genreId;
    private Boolean availability;

    public Book toEntity(Author author, Genre genre) {
        return new Book(null, title, isbn, publicationYear, author, genre, availability, new HashSet<>());
    }
}
