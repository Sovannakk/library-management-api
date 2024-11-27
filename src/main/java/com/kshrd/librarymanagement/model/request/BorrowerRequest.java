package com.kshrd.librarymanagement.model.request;
import com.kshrd.librarymanagement.model.Borrower;
import lombok.*;

import java.util.HashSet;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BorrowerRequest {
    private String name;
    private String email;
    private String phoneNumber;

    public Borrower toEntity() {
        return new Borrower(null, name, email, phoneNumber, new HashSet<>());
    }

    public Borrower toEntity(Long id) {
        return new Borrower(id, name, email, phoneNumber, new HashSet<>());
    }
}
