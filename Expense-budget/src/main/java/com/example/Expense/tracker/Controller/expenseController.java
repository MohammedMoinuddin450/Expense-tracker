package com.example.Expense.tracker.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense.tracker.DTO.expenseDTO;
import com.example.Expense.tracker.Model.Expense;
import com.example.Expense.tracker.Service.expenseService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/expensetracker/expenses")
public class expenseController {
    private expenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<String> addExpense(@RequestBody expenseDTO eDto ) {
        Expense exp=new Expense();
        exp.setAmount(eDto.getAmount());
        exp.setCategory(eDto.getCategory());
        exp.setDescription(eDto.getDescription());
        expenseService.addExpense(exp);
        return ResponseEntity.ok("Exppense added successfully!");
    }

    @GetMapping("/allexpenses")
    public ResponseEntity<List<expenseDTO>> allexpenses() {
        List<expenseDTO> all=expenseService.allexpenses();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/category")
    public ResponseEntity<List<expenseDTO>> category(@RequestParam String category){
        List<expenseDTO> cat=expenseService.category(category);
        return ResponseEntity.ok(cat);
    }

    @GetMapping("/totalexpense")
    public ResponseEntity<Double> TExpense(@RequestParam int month, int year){
        Double TE=expenseService.totalexpense(month, year);
        return ResponseEntity.ok(TE);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateExpense(@PathVariable long id, @RequestBody expenseDTO eDto) {
        expenseService.updateExpense(id,eDto);
        return ResponseEntity.ok("Exppense updated successfully!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Exppense deleted Succesfully");
    }
}
