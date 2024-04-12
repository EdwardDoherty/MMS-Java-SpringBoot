package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.ExpenseListDTO;
import com.MMS.MMS.model.OperatingExpense;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import com.MMS.MMS.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PageController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
//    private User user;
//    private Expense expense;
//    private Model model;

    // Home Page
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("expenseDB", model);

        return "homePage";
    }

    // Thymeleaf Template example
    @GetMapping(value = "/thymeleafTemplate")
    public String getTemplate(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        return "thymeleafTemplate";
    }

    // Login page
    @GetMapping("/login")
    public String login(@RequestParam(name="error", required=false) String error, Model model) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("error", error);
        return "login";
    }

    // Dashboard page
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");
        if(loggedUser != null) {
            if(loggedUser.getUserName() != null) {
                return "dashboard";
            }
        }
        return "redirect:/login?error=true";
    }

    // View & Edit Expenses Page
    @GetMapping(value="/viewExpenses")
    public String viewExpenses(HttpSession session, Model model) {

        User loggedUser = (User) session.getAttribute("loggedUser");
        OperatingExpense newExpense = new OperatingExpense(loggedUser.getUserID());

        model.addAttribute("allExpenses", loggedUser.get;
        model.addAttribute("newExpense", newExpense);
    return "viewEditExpenses";
    }

    // Create Account page
    @GetMapping(value = "/createAccount")
    public String createAccount(Model model){
        User newUser = new User();
        model.addAttribute("newUser", newUser);

        return "createAccount";
    }

    // Create Expense page
    @GetMapping(value = "/createExpense")
    public String createExpense(Model model, HttpSession session){
        User loggedUser = (User) session.getAttribute("loggedUser");
        OperatingExpense newExpense = new OperatingExpense(loggedUser.getUserID());
        model.addAttribute("newExpense", newExpense);

        return "createExpense";
    }

}
