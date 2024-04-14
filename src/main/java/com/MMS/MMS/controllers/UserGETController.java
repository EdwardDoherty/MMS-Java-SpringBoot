package com.MMS.MMS.controllers;

import com.MMS.MMS.model.User;
import jakarta.servlet.http.HttpSession;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class UserGETController {

//    @RequestMapping("/user/{id}")
//    public String getUser(@PathVariable String id, HttpSession session) {
//        // Trying to rewrite for DTOs...
////        if(userRepository.existsById(id)) {
////            User userLogin = userRepository.findById(id).get();
////            ObjectId userID = userLogin.getUserID();
//
//            //List<ExpenseDTO> expenseDTOList = new ArrayList<ExpenseDTO>( ExpenseController.getExpenseDTOsByUserID(userID));
//
//            //UserDTO userDTO = new UserDTO(userLogin, );
//
//            session.setAttribute("loggedUser", userLogin);
//            return "redirect:/dashboard";
//        }
//        else {
//            return "redirect:/login?error=true";
//        }
//    }

}
