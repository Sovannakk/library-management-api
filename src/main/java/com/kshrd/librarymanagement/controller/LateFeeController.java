package com.kshrd.librarymanagement.controller;

import com.kshrd.librarymanagement.model.LateFee;
import com.kshrd.librarymanagement.model.request.LateFeeRequest;
import com.kshrd.librarymanagement.model.response.ApiResponse;
import com.kshrd.librarymanagement.service.LateFeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/lateFees")
@RequiredArgsConstructor
public class LateFeeController {

    private final LateFeeService lateFeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<LateFee>>> getAllLateFees() {
        ApiResponse<List<LateFee>> response = ApiResponse.<List<LateFee>>builder()
                .message("Get all lateFees successfully")
                .status(HttpStatus.OK)
                .payload(lateFeeService.getAllLateFees())
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<LateFee>> getLateFee(@PathVariable Long id) {
        ApiResponse<LateFee> response = ApiResponse.<LateFee>builder()
                .message("Get lateFee successfully")
                .status(HttpStatus.OK)
                .payload(lateFeeService.getLateFee(id))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<LateFee>> createLateFee(@RequestBody LateFeeRequest LateFeeRequest) {
        ApiResponse<LateFee> response = ApiResponse.<LateFee>builder()
                .message("Create lateFee successfully")
                .status(HttpStatus.CREATED)
                .payload(lateFeeService.createLateFee(LateFeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<LateFee>> updateLateFee(@PathVariable Long id, @RequestBody LateFeeRequest LateFeeRequest) {
        ApiResponse<LateFee> response = ApiResponse.<LateFee>builder()
                .message("Update lateFee successfully")
                .status(HttpStatus.OK)
                .payload(lateFeeService.updateLateFee(id, LateFeeRequest))
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<LateFee>> deleteLateFee(@PathVariable Long id) {
        lateFeeService.deleteLateFee(id);
        ApiResponse<LateFee> response = ApiResponse.<LateFee>builder()
                .message("Delete lateFee successfully")
                .status(HttpStatus.OK)
                .payload(null)
                .timestamp(LocalDateTime.now())
                .build();
        return ResponseEntity.ok(response);
    }

}
