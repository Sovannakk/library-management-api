package com.kshrd.librarymanagement.service.impl;

import com.kshrd.librarymanagement.model.BorrowRecord;
import com.kshrd.librarymanagement.model.LateFee;
import com.kshrd.librarymanagement.model.request.LateFeeRequest;
import com.kshrd.librarymanagement.repository.BorrowRecordRepository;
import com.kshrd.librarymanagement.repository.LateFeeRepository;
import com.kshrd.librarymanagement.service.LateFeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LateFeeServiceImpl implements LateFeeService {

    private final LateFeeRepository lateFeeRepository;
    private final BorrowRecordRepository borrowRecordRepository;

    @Override
    public List<LateFee> getAllLateFees() {
        return lateFeeRepository.findAll();
    }

    @Override
    public LateFee getLateFee(Long id) {
        return lateFeeRepository.findById(id).orElse(null);
    }

    @Override
    public LateFee createLateFee(LateFeeRequest lateFeeRequest) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(lateFeeRequest.getBorrowRecordId()).orElse(null);
        return lateFeeRepository.save(lateFeeRequest.toEntity(borrowRecord));
    }

    @Override
    public LateFee updateLateFee(Long id, LateFeeRequest lateFeeRequest) {
        BorrowRecord borrowRecord = borrowRecordRepository.findById(lateFeeRequest.getBorrowRecordId()).orElse(null);
        return lateFeeRepository.save(lateFeeRequest.toEntity(id, borrowRecord));
    }

    @Override
    public void deleteLateFee(Long id) {
        lateFeeRepository.deleteById(id);
    }
}
