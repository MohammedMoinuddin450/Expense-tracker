package com.example.Expense.tracker.Model;

import java.time.LocalDate;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Entity
@Data
public class Expense {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String category;
    private String description;
    private Double amount;
    private LocalDate date;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDate.now();
    }
}
