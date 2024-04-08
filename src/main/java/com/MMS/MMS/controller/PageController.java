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

    // Create Account page
    @GetMapping(value = "/createAccount")
    public String createAccount(Model model){
        model.addAttribute("newUser", new User());

        return "createAccount";
    }

    // Create Expense page
    @GetMapping(value = "/createExpense")
    public String createExpense(Model model){
        model.addAttribute("newExpense", new OperatingExpense());

        return "createExpense";
    }

}
