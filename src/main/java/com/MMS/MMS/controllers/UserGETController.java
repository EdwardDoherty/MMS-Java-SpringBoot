package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import com.MMS.MMS.service.user_services.UserService;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserGETController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService = new UserService(userRepository);


    // Handle userLogin
    @RequestMapping("/logInUser/{userID}")
    public String logInUser(@PathVariable ObjectId userID, HttpSession session) {
        // This should likely be more abstracted and not sending redirects (and definitely not using URL params)
        // TODO: Proper secure authorization. This is for development purposes only, obviously.

        try {
            User user = userService.getUserById(userID);
            UserDTO loggedUser = new UserDTO(user.getUserID(),user.getUserName());
            session.setAttribute("loggedUser", loggedUser);
            return "redirect:/dashboard";
        }
        catch (Exception e) {
            return "redirect:/login?error=true";
        }
    }


}
