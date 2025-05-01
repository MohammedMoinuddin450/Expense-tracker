package com.example.Expense.tracker.Model;

import java.time.Year;
import java.time.YearMonth;

import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
@Data
public class budget {
    @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private int bid;
    private YearMonth month;
    private Year year;
    private Double amount;
}