package com.kshrd.librarymanagement.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "latefees")
@AllArgsConstructor
@NoArgsConstructor
public class LateFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "borrowRecord_id", nullable = false)
    private BorrowRecord borrowRecord;

    private BigDecimal lateFee;
}
