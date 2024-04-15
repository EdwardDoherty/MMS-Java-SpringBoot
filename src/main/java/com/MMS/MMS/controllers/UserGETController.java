package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import com.MMS.MMS.service.entityServices.UserService;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserGETController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService = new UserService(userRepository);


    // Handle userLogin
    @RequestMapping("/logInUser/{userID}")
    public String logInUser(@PathVariable ObjectId userID, HttpSession session) {

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

    // Find All Users
    public List<UserDTO> getAllUsers(){
        // Returns UserDTO
        List<User> userList = new ArrayList<User>(userRepository.findAll());
        List<UserDTO> userDTOList = new ArrayList<>();

        for(User user : userList){
            UserDTO userDTO = new UserDTO(user.getUserID(),user.getUserName());
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }
}
