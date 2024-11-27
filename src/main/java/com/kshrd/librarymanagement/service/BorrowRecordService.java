package com.kshrd.librarymanagement.service;

import com.kshrd.librarymanagement.model.BorrowRecord;
import com.kshrd.librarymanagement.model.request.BorrowRecordRequest;

import java.util.List;

public interface BorrowRecordService {
    List<BorrowRecord> getAllBorrowRecords();

    BorrowRecord getBorrowRecord(Long id);

    BorrowRecord createBorrowRecord(BorrowRecordRequest borrowRecordRequest);

    BorrowRecord updateBorrowRecord(Long id, BorrowRecordRequest borrowRecordRequest);

    void deleteBorrowRecord(Long id);

    BorrowRecord returnBook(Long id);

    List<BorrowRecord> getOverdueBorrowRecords();
}
