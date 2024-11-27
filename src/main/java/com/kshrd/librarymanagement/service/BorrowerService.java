package com.kshrd.librarymanagement.service;

import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.Borrower;
import com.kshrd.librarymanagement.model.LateFee;
import com.kshrd.librarymanagement.model.request.BorrowerRequest;

import java.util.List;

public interface BorrowerService {
    List<Borrower> getAllBorrowers();

    Borrower getBorrower(Long id);

    Borrower createBorrower(BorrowerRequest borrowerRequest);

    Borrower updateBorrower(Long id, BorrowerRequest borrowerRequest);

    void deleteBorrower(Long id);

    List<Book> getAllBorrowedBooks(Long id);

    List<LateFee> getAllLateFeesByBorrower(Long id);
}
