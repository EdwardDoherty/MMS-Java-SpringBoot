package com.MMS.MMS.controller;

import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private User user;
    private Model model;

    @PostMapping("/addUser")
    public String addUser(Model model, @ModelAttribute("newUser") User newUser) {
        if(newUser.getUserName() != null && !newUser.getUserName().equals("")) {
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
        if(userRepository.existsById(id)) {
            User userLogin = userRepository.findById(id).get();
            session.setAttribute("loggedUser", userLogin);
            return "redirect:/dashboard";
        }
        else {
            return "redirect:/login?error=true";
        }
    }

}
