package com.kshrd.librarymanagement.model.request;

import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.BorrowRecord;
import com.kshrd.librarymanagement.model.Borrower;
import com.kshrd.librarymanagement.model.enums.BorrowStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowRecordRequest {
    private Long borrowerId;
    private Long bookId;
    private LocalDate borrowDate;
    private LocalDate expectedReturnDate;

    public BorrowRecord toEntity(Borrower borrower, Book book) {
        return new BorrowRecord(null, borrower, book, borrowDate, expectedReturnDate, null, BorrowStatus.BORROWED);
    }

    public BorrowRecord toEntity(Long id, Borrower borrower, Book book) {
        return new BorrowRecord(id, borrower, book, borrowDate, expectedReturnDate, null, BorrowStatus.BORROWED);
    }
}
