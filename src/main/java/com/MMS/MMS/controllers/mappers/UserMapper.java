package com.MMS.MMS.controllers.mappers;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import com.MMS.MMS.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserMapper {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExpenseRepository expenseRepository;

    public UserDTO toUserDTO(User user) {
        ObjectId userID = user.getUserID();
        String userName = user.getUserName();
        ArrayList<ExpenseDTO> userExpenses = expenseRepository.findAllByUserID(userID);


        return new UserDTO(userID, userName);
    }

}
