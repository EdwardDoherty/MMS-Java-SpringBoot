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
public class UserDTOMapper {

    @Autowired
    private UserRepository userRepository;


//    public UserDTO toUserDTO(User user, ExpenseListDTO expenses) {
    public UserDTO toUserDTO(User user) {
        ObjectId userID = user.getUserID();
        String userName = user.getUserName();

//        return new UserDTO(userID, userName, userExpenses);
        return new UserDTO(userID, userName);
    }

    public UserDTO ConvertToDTO(User user){
        return new UserDTO(user.getUserID(), user.getUserName());
    }

    public User ConvertToUser(UserDTO userDTO) {
        return new User(userDTO.getUserID(), userDTO.getUserName());
    }

}
