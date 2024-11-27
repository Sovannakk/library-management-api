package com.kshrd.librarymanagement.model.request;

import com.kshrd.librarymanagement.model.BorrowRecord;
import com.kshrd.librarymanagement.model.LateFee;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LateFeeRequest {
    private Long borrowRecordId;
    private BigDecimal lateFee;

    public LateFee toEntity(BorrowRecord borrowRecord) {
        return new LateFee(null, borrowRecord, lateFee);
    }

    public LateFee toEntity(Long id, BorrowRecord borrowRecord) {
        return new LateFee(id, borrowRecord, lateFee);
    }
}
