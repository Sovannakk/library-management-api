package com.kshrd.librarymanagement.model.request;

import com.kshrd.librarymanagement.model.Author;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequest {
    private String name;
    private LocalDate birthdate;
    private String nationality;
    private String biography;

    public Author toEntity() {
        return new Author(null, name, birthdate, nationality, biography);
    }

    public Author toEntity(Long id) {
        return new Author(id, name, birthdate, nationality, biography);
    }
}
