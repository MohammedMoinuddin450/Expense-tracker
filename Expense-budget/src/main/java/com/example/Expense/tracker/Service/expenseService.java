package com.example.Expense.tracker.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.Expense.tracker.DTO.expenseDTO;
import com.example.Expense.tracker.Model.Expense;

import com.example.Expense.tracker.Repository.repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class expenseService {

    private repository repo;
    
    public void addExpense(Expense exp ) {
        repo.save(exp);
    }


    public void updateExpense(long id ,expenseDTO eDto) {
        Expense exp=repo.findById(id).orElseThrow();
        exp.setAmount(eDto.getAmount());
        exp.setCategory(eDto.getCategory());
        exp.setDescription(eDto.getDescription());
        repo.save(exp);
    }


    public void deleteExpense(Long id) {
        repo.deleteById(id);
    }


    public List<expenseDTO> allexpenses() {
        List<Expense> all=repo.findAll();
        return all.stream()
              .map(Expense -> new expenseDTO(
                  Expense.getDescription(),
                  Expense.getAmount(),
                  Expense.getCategory()
              ))
              .collect(Collectors.toList());
    }


    public List<expenseDTO> category(String category) {
        List<expenseDTO> cats=repo.findByCategory(category);
        return cats;
    }


    public Double totalexpense(int month, int year) {
        
        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
        List<expenseDTO> total=repo.findByDateBetween(startDate, endDate);
        return total.stream().
        mapToDouble(expenseDTO::getAmount)  
        .sum();
    }
    
   
}
