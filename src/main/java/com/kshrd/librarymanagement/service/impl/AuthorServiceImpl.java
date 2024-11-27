package com.kshrd.librarymanagement.service.impl;

import com.kshrd.librarymanagement.model.Author;
import com.kshrd.librarymanagement.model.request.AuthorRequest;
import com.kshrd.librarymanagement.repository.AuthorRepository;
import com.kshrd.librarymanagement.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author getAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public Author createAuthor(AuthorRequest authorRequest) {
        return authorRepository.save(authorRequest.toEntity());
    }

    @Override
    public Author updateAuthor(Long id, AuthorRequest authorRequest) {
        return authorRepository.save(authorRequest.toEntity(id));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
