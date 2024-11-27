package com.kshrd.librarymanagement.repository;

import com.kshrd.librarymanagement.model.BorrowRecord;
import com.kshrd.librarymanagement.model.enums.BorrowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Long> {

    List<BorrowRecord> findAllByStatus(BorrowStatus status);

}
