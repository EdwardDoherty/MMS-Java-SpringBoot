package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private User user;
    private Model model;

    @PostMapping("/addUser")
    public String addUser(Model model, @ModelAttribute("newUser") User newUser) {
        if(newUser.getUserName() != null && !newUser.getUserName().isEmpty()) {
            userRepository.save(newUser);
            return "redirect:/login";
        }

        return "redirect:/createAccount?error=true";
    }

    @GetMapping("/getAllUsers")
    public String getUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());

        return "getAllUsers";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable String id) {
        userRepository.deleteById(id);

        return "redirect:/getAllUsers";
    }

    @RequestMapping("/user/{id}")
    public String getUser(@PathVariable String id, HttpSession session) {
        // Trying to rewrite for DTOs...
        if(userRepository.existsById(id)) {
            User userLogin = userRepository.findById(id).get();
            ObjectId userID = userLogin.getUserID();

            //List<ExpenseDTO> expenseDTOList = new ArrayList<ExpenseDTO>( ExpenseController.getExpenseDTOsByUserID(userID));

            //UserDTO userDTO = new UserDTO(userLogin, );

            session.setAttribute("loggedUser", userLogin);
            return "redirect:/dashboard";
        }
        else {
            return "redirect:/login?error=true";
        }
    }

}
