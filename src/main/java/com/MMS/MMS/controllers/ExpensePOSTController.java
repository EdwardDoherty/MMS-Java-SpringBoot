package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class ExpensePOSTController {

    @Autowired
    private ExpenseRepository expenseRepository;

    private UserDTO user;
    private ExpenseDTO expense;
    private Model model;

    @PostMapping("/addExpense")
    public String addExpense(HttpSession session, @ModelAttribute("newExpense") ExpenseDTO newExpense) {
        // Adjust entire method for DTOs
        User loggedUser = (User) session.getAttribute("loggedUser");
        // newExpense.setUserID(loggedUser.getUserID());
        if(newExpense.getName() != null && !newExpense.getName().isEmpty()) {
            //expenseRepository.save(newExpense);
            return "redirect:/viewExpenses";
        }

        return "redirect:/viewExpenses?error=true";

    }

    @PostMapping("/deleteExpense/{id}")
    public String deleteExpense(@PathVariable String id) {
        expenseRepository.deleteById(id);

        return "redirect:/viewExpenses";
    }

    @PostMapping("/editExpense/{id}")
    public String editExpense(@PathVariable String id) {
        expenseRepository.deleteById(id);

        return "redirect:/viewExpenses";
    }




}
