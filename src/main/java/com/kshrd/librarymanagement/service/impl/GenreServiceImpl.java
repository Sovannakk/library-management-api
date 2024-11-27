package com.kshrd.librarymanagement.service.impl;

import com.kshrd.librarymanagement.model.Genre;
import com.kshrd.librarymanagement.model.request.GenreRequest;
import com.kshrd.librarymanagement.repository.GenreRepository;
import com.kshrd.librarymanagement.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;

    @Override
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    @Override
    public Genre getGenre(Long id) {
        return genreRepository.findById(id).orElse(null);
    }

    @Override
    public Genre createGenre(GenreRequest genreRequest) {
        return genreRepository.save(genreRequest.toEntity());
    }

    @Override
    public Genre updateGenre(Long id, GenreRequest genreRequest) {
        return genreRepository.save(genreRequest.toEntity(id));
    }

    @Override
    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }
}
