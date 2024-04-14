package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.UserCreationDTO;
import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import com.MMS.MMS.service.entityServices.BadUserDataException;
import com.MMS.MMS.service.entityServices.UserNotFoundException;
import com.MMS.MMS.service.entityServices.UserService;
import com.MMS.MMS.service.mappers.UserDTOMapper;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserPOSTController {
    // Expose functionality so that it can be consumed by external entities (including UI)
    // If someone wants to access business logic, they go through a controller to get there.
    // If code is dealing with exposing functionality, it goes in the controller.
    // Controller is passing work between Repository and Service layer

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService = new UserService(userRepository);


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(Model model, @ModelAttribute("newUser") UserCreationDTO newUser) {

        try{
            User user = new User(new ObjectId(), newUser.getUserName());
            userService.saveUser(user);
            return "redirect:/login";
        }
        catch(Exception e){
            return "redirect:/createAccount?error=true";
        }
    }


    @PostMapping("/delete/{userID}")
    public String deleteUser(@PathVariable ObjectId userID) {

        try {
            userService.deleteUserById(userID);
            return "redirect:/getAllUsers";
        }
        catch (Exception e) {
            return "redirect:/getAllUsers?error=true";
        }

    }

}
