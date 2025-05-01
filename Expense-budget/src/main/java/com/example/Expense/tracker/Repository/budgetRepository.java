package com.example.Expense.tracker.Repository;

import java.time.Year;
import java.time.YearMonth;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Expense.tracker.Model.budget;

@Repository
public interface budgetRepository extends JpaRepository<budget, Integer> 
{
    Optional<budget> findByMonthAndYear(YearMonth month, Year year);
}
