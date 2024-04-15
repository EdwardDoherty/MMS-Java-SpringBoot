package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.UserCreationDTO;
import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.FixedExpense;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import com.MMS.MMS.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PageController {

    private final UserGETController userGETController = new UserGETController();


    // Home Page
    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("expenseDB", model);

        return "homePage";
    }

    // Thymeleaf Template example
    @GetMapping("/thymeleafTemplate")
    public String getTemplate(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        return "thymeleafTemplate";
    }

    // Login page
    @GetMapping("/login")
    public String login(@RequestParam(name="error", required=false) String error, Model model) {
        model.addAttribute("users", userGETController.getAllUsers());
        model.addAttribute("error", error);
        return "login";
    }

    // Dashboard page
    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model) {

        UserDTO loggedUser = (UserDTO) session.getAttribute("loggedUser");
        if(loggedUser != null) {
            if(loggedUser.getUserName() != null) {
                return "dashboard";
            }
        }
        return "redirect:/login?error=true";
    }

    // Get All Users page. Here you can delete users. For testing purposes only.
    @GetMapping("/getAllUsers")
    public String getUsers(Model model) {
        model.addAttribute("users", userGETController.getAllUsers());

        return "getAllUsers";
    }

    // Create Account page
    @GetMapping("/createAccount")
    public String createAccount(Model model){
        UserCreationDTO newUser = new UserCreationDTO( null);
        model.addAttribute("newUser", newUser);

        return "createAccount";
    }

    // View & Edit Expenses Page
    @GetMapping("/viewExpenses")
    public String viewExpenses(HttpSession session, Model model) {
        // This needs to be rewritten for DTOs, currently broken
        // User loggedUser = (User) session.getAttribute("loggedUser");
        // FixedExpense newExpense = new FixedExpense();
        // model.addAttribute("allExpenses", loggedUser);
        // model.addAttribute("newExpense", newExpense);

    return "viewEditExpenses";
    }

    // Create Expense page
    @GetMapping("/createExpense")
    public String createExpense(Model model, HttpSession session){
        // Needs to be rewritten for DTOs, currently broken
        // User loggedUser = (User) session.getAttribute("loggedUser");
        // ExpenseDTO newExpense = new ExpenseDTO();
        // model.addAttribute("newExpense", newExpense);

        return "createExpense";
    }

}
