package com.kshrd.librarymanagement.service.impl;

import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.BorrowRecord;
import com.kshrd.librarymanagement.model.Borrower;
import com.kshrd.librarymanagement.model.enums.BorrowStatus;
import com.kshrd.librarymanagement.model.request.BorrowRecordRequest;
import com.kshrd.librarymanagement.repository.BookRepository;
import com.kshrd.librarymanagement.repository.BorrowRecordRepository;
import com.kshrd.librarymanagement.repository.BorrowerRepository;
import com.kshrd.librarymanagement.service.BorrowRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BorrowRecordServiceImpl implements BorrowRecordService {

    private final BorrowRecordRepository borrowRecordRepository;
    private final BorrowerRepository borrowerRepository;
    private final BookRepository bookRepository;

    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    @Override
    public BorrowRecord getBorrowRecord(Long id) {
        return borrowRecordRepository.findById(id).orElse(null);
    }

    @Override
    public BorrowRecord createBorrowRecord(BorrowRecordRequest borrowRecordRequest) {
        Borrower borrower = borrowerRepository.findById(borrowRecordRequest.getBorrowerId()).orElse(null);
        Book book = bookRepository.findById(borrowRecordRequest.getBookId()).orElse(null);
        return borrowRecordRepository.save(borrowRecordRequest.toEntity(borrower, book));
    }

    @Override
    public BorrowRecord updateBorrowRecord(Long id, BorrowRecordRequest borrowRecordRequest) {
        Borrower borrower = borrowerRepository.findById(id).orElse(null);
        Book book = bookRepository.findById(borrowRecordRequest.getBookId()).orElse(null);
        return borrowRecordRepository.save(borrowRecordRequest.toEntity(id, borrower, book));
    }

    @Override
    public void deleteBorrowRecord(Long id) {
        borrowRecordRepository.deleteById(id);
    }

    @Override
    public BorrowRecord returnBook(Long id) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(id).orElse(null);
        assert borrowRecord != null;
        borrowRecord.setStatus(BorrowStatus.RETURNED);
        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public List<BorrowRecord> getOverdueBorrowRecords() {
        return borrowRecordRepository.findAllByStatus(BorrowStatus.OVERDUE);
    }
}
