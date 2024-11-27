package com.kshrd.librarymanagement.controller;

import com.kshrd.librarymanagement.model.Book;
import com.kshrd.librarymanagement.model.Borrower;
import com.kshrd.librarymanagement.model.LateFee;
import com.kshrd.librarymanagement.model.request.BorrowerRequest;
import com.kshrd.librarymanagement.model.response.ApiResponse;
import com.kshrd.librarymanagement.service.BorrowerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/borrowers")
@RequiredArgsConstructor
public class BorrowerController {

    private final BorrowerService borrowerService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<Borrower>>> getAllBorrowers() {
        ApiResponse<List<Borrower>> response = ApiResponse.<List<Borrower>>builder()
                .message("Get all borrowers successfully")
                .status(HttpStatus.OK)
                .payload(borrowerService.getAllBorrowers())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Borrower>> getBorrower(@PathVariable Long id) {
        ApiResponse<Borrower> response = ApiResponse.<Borrower>builder()
                .message("Get borrower successfully")
                .status(HttpStatus.OK)
                .payload(borrowerService.getBorrower(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<Borrower>> createBorrower(@RequestBody BorrowerRequest BorrowerRequest) {
        ApiResponse<Borrower> response = ApiResponse.<Borrower>builder()
                .message("Create borrower successfully")
                .status(HttpStatus.CREATED)
                .payload(borrowerService.createBorrower(BorrowerRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Borrower>> updateBorrower(@PathVariable Long id, @RequestBody BorrowerRequest BorrowerRequest) {
        ApiResponse<Borrower> response = ApiResponse.<Borrower>builder()
                .message("Update borrower successfully")
                .status(HttpStatus.OK)
                .payload(borrowerService.updateBorrower(id, BorrowerRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Borrower>> deleteBorrower(@PathVariable Long id) {
        borrowerService.deleteBorrower(id);
        ApiResponse<Borrower> response = ApiResponse.<Borrower>builder()
                .message("Delete borrower successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/borrowedBooks")
    public ResponseEntity<ApiResponse<List<Book>>> getAllBorrowedBooks(@PathVariable Long id) {
        ApiResponse<List<Book>> response = ApiResponse.<List<Book>>builder()
                .message("Get all borrowed books successfully")
                .status(HttpStatus.OK)
                .payload(borrowerService.getAllBorrowedBooks(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/lateFees")
    public ResponseEntity<ApiResponse<List<LateFee>>> getAllLateFeesByBorrower(@PathVariable Long id) {
        ApiResponse<List<LateFee>> response = ApiResponse.<List<LateFee>>builder()
                .message("Get all late fees by borrower successfully")
                .status(HttpStatus.OK)
                .payload(borrowerService.getAllLateFeesByBorrower(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

}
