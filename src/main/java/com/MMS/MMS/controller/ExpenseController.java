package com.MMS.MMS.controller;

import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import com.MMS.MMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;
    private User user;
    private Expense expense;
    private Model model;

    @PostMapping("/addExpense")
    public String addExpense(@ModelAttribute Expense expense, Model model) {

        expenseRepository.save(expense);

        return "redirect:/dashboard";
    }


}
