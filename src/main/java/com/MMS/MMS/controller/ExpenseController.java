package com.MMS.MMS.controller;

import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.OperatingExpense;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import com.MMS.MMS.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
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
    public String addExpense(HttpSession session, @ModelAttribute("newExpense") OperatingExpense newExpense) {
        User loggedUser = (User) session.getAttribute("loggedUser");
        newExpense.setUserID(loggedUser.getUserID());
        if(newExpense.getName() != null && !newExpense.getName().equals("")) {
            expenseRepository.save(newExpense);
            return "redirect:/viewExpenses";
        }

        return "redirect:/viewExpenses?error=true";

    }


}
