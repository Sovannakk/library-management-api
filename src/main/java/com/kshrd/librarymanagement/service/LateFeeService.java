package com.kshrd.librarymanagement.service;

import com.kshrd.librarymanagement.model.LateFee;
import com.kshrd.librarymanagement.model.request.LateFeeRequest;

import java.util.List;

public interface LateFeeService {
    List<LateFee> getAllLateFees();

    LateFee getLateFee(Long id);

    LateFee createLateFee(LateFeeRequest lateFeeRequest);

    LateFee updateLateFee(Long id, LateFeeRequest lateFeeRequest);

    void deleteLateFee(Long id);
}
