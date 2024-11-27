package com.kshrd.librarymanagement.service;

import com.kshrd.librarymanagement.model.Genre;
import com.kshrd.librarymanagement.model.request.GenreRequest;

import java.util.List;

public interface GenreService {
    List<Genre> getAllGenres();

    Genre getGenre(Long id);

    Genre createGenre(GenreRequest genreRequest);

    Genre updateGenre(Long id, GenreRequest genreRequest);

    void deleteGenre(Long id);
}
