package com.MMS.MMS.controllers;

import com.MMS.MMS.controllers.mappers.ExpenseMapper;
import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.OperatingExpense;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        if(newExpense.getName() != null && !newExpense.getName().isEmpty()) {
            expenseRepository.save(newExpense);
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

    @GetMapping
    @ResponseBody
    public List<ExpenseDTO> getExpensesByUserID(ObjectId userID) {
        return expenseRepository.findAllByUserID(userID)
                .stream()
                .map(ExpenseMapper::toDTO)
                .collect(Collectors.toList());
    }


}
