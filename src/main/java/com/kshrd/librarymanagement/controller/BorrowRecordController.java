package com.kshrd.librarymanagement.controller;

import com.kshrd.librarymanagement.model.BorrowRecord;
import com.kshrd.librarymanagement.model.request.BorrowRecordRequest;
import com.kshrd.librarymanagement.model.response.ApiResponse;
import com.kshrd.librarymanagement.service.BorrowRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/borrowRecords")
@RequiredArgsConstructor
public class BorrowRecordController {

    private final BorrowRecordService borrowRecordService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<BorrowRecord>>> getAllBorrowRecords() {
        ApiResponse<List<BorrowRecord>> response = ApiResponse.<List<BorrowRecord>>builder()
                .message("Get all borrow records successfully")
                .status(HttpStatus.OK)
                .payload(borrowRecordService.getAllBorrowRecords())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BorrowRecord>> getBorrowRecord(@PathVariable Long id) {
        ApiResponse<BorrowRecord> response = ApiResponse.<BorrowRecord>builder()
                .message("Get borrow record successfully")
                .status(HttpStatus.OK)
                .payload(borrowRecordService.getBorrowRecord(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<BorrowRecord>> createBorrowRecord(@RequestBody BorrowRecordRequest BorrowRecordRequest) {
        ApiResponse<BorrowRecord> response = ApiResponse.<BorrowRecord>builder()
                .message("Create borrow record successfully")
                .status(HttpStatus.CREATED)
                .payload(borrowRecordService.createBorrowRecord(BorrowRecordRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<BorrowRecord>> updateBorrowRecord(@PathVariable Long id, @RequestBody BorrowRecordRequest BorrowRecordRequest) {
        ApiResponse<BorrowRecord> response = ApiResponse.<BorrowRecord>builder()
                .message("Update borrow record successfully")
                .status(HttpStatus.OK)
                .payload(borrowRecordService.updateBorrowRecord(id, BorrowRecordRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<BorrowRecord>> deleteBorrowRecord(@PathVariable Long id) {
        borrowRecordService.deleteBorrowRecord(id);
        ApiResponse<BorrowRecord> response = ApiResponse.<BorrowRecord>builder()
                .message("Delete borrow record successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{id}/return")
    public ResponseEntity<ApiResponse<BorrowRecord>> returnBook(@PathVariable Long id) {
        ApiResponse<BorrowRecord> response = ApiResponse.<BorrowRecord>builder()
                .message("Return borrow record successfully")
                .status(HttpStatus.CREATED)
                .payload(borrowRecordService.returnBook(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/overdue")
    public ResponseEntity<ApiResponse<List<BorrowRecord>>> getOverdueBorrowRecords() {
        ApiResponse<List<BorrowRecord>> response = ApiResponse.<List<BorrowRecord>>builder()
                .message("Get overdue borrow record successfully")
                .status(HttpStatus.OK)
                .payload(borrowRecordService.getOverdueBorrowRecords())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }
}
