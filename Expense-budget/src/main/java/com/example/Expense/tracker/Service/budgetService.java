package com.example.Expense.tracker.Service;

import java.time.Year;
import java.time.YearMonth;
import java.util.stream.DoubleStream;

import org.springframework.stereotype.Service;

import com.example.Expense.tracker.Model.budget;
import com.example.Expense.tracker.Repository.budgetRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class budgetService {

    private budgetRepository budr;

    public void setBudget(budget b) {
       budr.save(b);
    }

    public DoubleStream monthlybud(YearMonth month, Year year) {
    return budr.findByMonthAndYear(month,year).stream().
    mapToDouble(budget::getAmount);
    }

}
