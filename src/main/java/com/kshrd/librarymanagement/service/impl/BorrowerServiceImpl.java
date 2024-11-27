package com.kshrd.librarymanagement.service.impl;

import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.Borrower;
import com.kshrd.librarymanagement.model.LateFee;
import com.kshrd.librarymanagement.model.request.BorrowerRequest;
import com.kshrd.librarymanagement.repository.BorrowerRepository;
import com.kshrd.librarymanagement.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowerServiceImpl implements BorrowerService {

    private final BorrowerRepository borrowerRepository;

    @Override
    public List<Borrower> getAllBorrowers() {
        return borrowerRepository.findAll();
    }

    @Override
    public Borrower getBorrower(Long id) {
        return borrowerRepository.findById(id).orElse(null);
    }

    @Override
    public Borrower createBorrower(BorrowerRequest borrowerRequest) {
        return borrowerRepository.save(borrowerRequest.toEntity());
    }

    @Override
    public Borrower updateBorrower(Long id, BorrowerRequest borrowerRequest) {
        return borrowerRepository.save(borrowerRequest.toEntity(id));
    }

    @Override
    public void deleteBorrower(Long id) {
        borrowerRepository.deleteById(id);
    }

    @Override
    public List<Book> getAllBorrowedBooks(Long id) {
        Borrower borrower = borrowerRepository.findById(id).orElse(null);
        assert borrower != null;
        return borrower.getBooks().stream().toList();
    }

    @Override
    public List<LateFee> getAllLateFeesByBorrower(Long id) {
        return List.of();
    }
}
