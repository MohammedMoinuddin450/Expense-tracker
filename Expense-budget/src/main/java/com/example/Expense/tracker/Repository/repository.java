package com.example.Expense.tracker.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Expense.tracker.DTO.expenseDTO;
import com.example.Expense.tracker.Model.Expense;

public interface repository extends JpaRepository<Expense/*DB table */ , Long/*primary key type */>{
    List<expenseDTO> findByDateBetween(LocalDate start, LocalDate end);
    List<expenseDTO> findByCategory(String category);
}
