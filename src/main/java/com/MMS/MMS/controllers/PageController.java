package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.UserCreationDTO;
import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.User;
import com.MMS.MMS.service.expense_services.ExpenseService;
import com.MMS.MMS.service.expense_services.ExpenseDTOMapper;
import com.MMS.MMS.service.user_services.UserService;
import com.MMS.MMS.service.user_services.UserDTOMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PageController {

    private final UserService userService;
    private final UserDTOMapper userDTOMapper;

    private final ExpenseService expenseService;
    private final ExpenseDTOMapper expenseDTOMapper;


    public PageController(UserService userService, UserDTOMapper userDTOMapper, ExpenseService expenseService, ExpenseDTOMapper expenseDTOMapper) {
        this.userService = userService;
        this.userDTOMapper = userDTOMapper;
        this.expenseService = expenseService;
        this.expenseDTOMapper = expenseDTOMapper;
    }

//    @GetMapping("/test")
//    public String Test(){
//        String head = "<!DOCTYPE html><head>" +
//                "    <meta http-equiv='Content-Type' content=\"text/html; charset=UTF-8\" />\n" +
//                "    <title>Test!</title>\n" +
//                "    <link href='src/main/resources/static/css/main.css' rel='stylesheet' />\n" +
//                "    <link rel='preconnect' href='https://fonts.googleapis.com'>\n" +
//                "    <link rel='preconnect' href='https://fonts.gstatic.com' crossorigin>\n" +
//                "    <link href='https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap' rel='stylesheet'>\n" +
//                "    <script src='https://kit.fontawesome.com/86a01f560a.js' crossorigin='anonymous'></script>\n" +
//                "</head>";
//
//        return head + "<h1>test</h1><p>This is a test!</p>";
//    }

    // Home Page
    @GetMapping("/")
    public String Index(Model model){
        model.addAttribute("expenseDB", model);

        return "homePage";
    }

    // Thymeleaf Template example
    @GetMapping("/thymeleafTemplate")
    public String GetTemplate(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);

        return "thymeleafTemplate";
    }

    // Login page
    @GetMapping("/login")
    public String Login(@RequestParam(name="error", required=false) String error, Model model) {
        try {
            List<User> userList = userService.getAllUsers();
            model.addAttribute("users", userDTOMapper.UserListToDTOs(userList));
            model.addAttribute("error", error);

            return "login";
        }
        catch(Exception e) {
            return "redirect:/error";
        }

    }

    // Dashboard page
    @GetMapping("/dashboard")
    public String Dashboard(HttpSession session) {

        UserDTO loggedUser = (UserDTO) session.getAttribute("loggedUser");
        if(loggedUser != null) {
            if(loggedUser.userName() != null) {
                return "dashboard";
            }
        }
        return "redirect:/login?error=true";
    }

    // Get All Users page. Here you can delete users. For testing purposes only.
    @GetMapping("/getAllUsers")
    public String GetAllUsers(Model model) {
        try {
            List<User> userList = userService.getAllUsers();
            model.addAttribute("users", userDTOMapper.UserListToDTOs(userList));

            return "getAllUsers";
        }
        catch(Exception e) {
            return "redirect:/error";
        }
    }

    // Create Account page
    @GetMapping("/createAccount")
    public String CreateAccount(Model model){
        UserCreationDTO newUser = new UserCreationDTO(null);
        model.addAttribute("newUser", newUser);

        return "createAccount";
    }

    // View & Edit Expenses Page
    @GetMapping("/viewExpenses")
    public String viewExpenses(HttpSession session, Model model) {

        if (session.getAttribute("loggedUser") != null) {
            UserDTO loggedUser = (UserDTO) session.getAttribute("loggedUser");

            // Get expenses from database
            List<Expense> expenseList = expenseService.getExpensesByUserId(loggedUser.userID());
            // Turn them into DTOs
            List<ExpenseDTO> expenseDTOList = expenseDTOMapper.convertListToDTO(expenseList);
            // Turn them into an array so Thymeleaf can use them
            ExpenseDTO[] expenseDTOArray = expenseDTOList.toArray(new ExpenseDTO[0]);

            model.addAttribute("allExpenses", expenseDTOArray);

            model.addAttribute("newExpense", expenseDTOMapper.quickCreateDTO(loggedUser.userID()));

            return "viewEditExpenses";
        } else {
            return "redirect:/login?error=true";
        }
    }

//    // Create Expense page
//    @GetMapping("/createExpense")
//    public String createExpense(Model model, HttpSession session){
//        // Needs to be rewritten for DTOs, currently broken
//        // User loggedUser = (User) session.getAttribute("loggedUser");
//        // ExpenseDTO newExpense = new ExpenseDTO();
//        // model.addAttribute("newExpense", newExpense);
//
//        return "createExpense";
//    }

}
