package com.example.Expense.tracker.Controller;

import java.time.Year;
import java.time.YearMonth;
import java.util.stream.DoubleStream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Expense.tracker.Model.budget;
import com.example.Expense.tracker.Service.budgetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/expensetracker/budget")
@AllArgsConstructor
public class budgetController {

    private budgetService bService;


    @PostMapping("/setbudget")
    public ResponseEntity<String> setBudget(@RequestBody budget bud){
        bService.setBudget(bud);
        return ResponseEntity.ok("Budget is setted");
    }
    

    @GetMapping("/month")
    public ResponseEntity<DoubleStream> getbudget(@RequestParam YearMonth month,Year year){
        DoubleStream amt=bService.monthlybud(month,year);
        return ResponseEntity.ok(amt);
    }

    
}
