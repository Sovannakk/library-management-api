package com.kshrd.librarymanagement.model.request;

import com.kshrd.librarymanagement.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreRequest {
    private String name;
    private String description;

    public Genre toEntity() {
        return new Genre(null, name, description);
    }

    public Genre toEntity(Long id) {
        return new Genre(id, name, description);
    }
}
