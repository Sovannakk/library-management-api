package com.kshrd.librarymanagement.repository;

import com.kshrd.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAuthorId(Long authorId);

    List<Book> findAllByGenreId(Long genreId);

    List<Book> findAllByAvailability(Boolean availability);

}
