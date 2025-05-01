package com.example.Expense.tracker.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class expenseDTO {
    private String description;
    private Double amount;
    private String category;
}
