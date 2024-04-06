package com.MMS.MMS.controller;

import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MmsController {

    @Autowired
    private UserRepository userRepository;
    private User user;
    private Model model;

    //Home Page
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("expenseDB", model);
        return "homePage";
    }

    @GetMapping(value = "/thymeleafTemplate")
    public String getTemplate(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "thymeleafTemplate";
    }


    // C.R.U.D.

    @GetMapping(value = "/createUser")
    public String createUser(Model model){
        model.addAttribute("newUser",new User());
        return "createUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user, Model model) {
        userRepository.save(user);

        return "redirect:/getAllUsers";
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



}
