package com.MMS.MMS.service.mappers;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.ExpenseListDTO;
import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserMapper {

    @Autowired
    private UserRepository userRepository;

    public UserDTO toUserDTO(User user, ExpenseListDTO expenses) {
        ObjectId userID = user.getUserID();
        String userName = user.getUserName();
        List<ExpenseDTO> userExpenses = expenses.getExpenses();

        return new UserDTO(userID, userName, userExpenses);
    }

    public UserDTO convertToDTO(User user){
        return new UserDTO();
    }

    public User convertToUser(UserDTO userDTO) {
        return new User();
    }

}