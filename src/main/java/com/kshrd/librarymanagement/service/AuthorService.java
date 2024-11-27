package com.kshrd.librarymanagement.service;

import com.kshrd.librarymanagement.model.Author;
import com.kshrd.librarymanagement.model.request.AuthorRequest;

import java.util.List;

public interface AuthorService {

    List<Author> getAllAuthors();

    Author getAuthor(Long id);

    Author createAuthor(AuthorRequest authorRequest);

    Author updateAuthor(Long id, AuthorRequest authorRequest);

    void deleteAuthor(Long id);
}