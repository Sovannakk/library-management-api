package com.kshrd.librarymanagement.repository;

import com.kshrd.librarymanagement.model.LateFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LateFeeRepository extends JpaRepository<LateFee, Long> {
}
