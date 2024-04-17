package com.MMS.MMS.service.user_services;

import com.MMS.MMS.dto.UserDTO;
import com.MMS.MMS.model.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDTOMapper {


    public UserDTO toUserDTO(User user) {
        ObjectId userID = user.getUserID();
        String userName = user.getUserName();

        return new UserDTO(userID, userName);
    }

    public UserDTO ConvertToDTO(User user){
        return new UserDTO(user.getUserID(), user.getUserName());
    }

    public User ConvertToUser(UserDTO userDTO) {
        return new User(userDTO.userID(), userDTO.userName());
    }

    // Turn a list of Users into a list of UserDTOs
    public List<UserDTO> UserListToDTOs(List<User> userList) {

        List<UserDTO> userDTOList = new ArrayList<>();

        for(User user : userList){
            UserDTO userDTO = ConvertToDTO(user);
            userDTOList.add(userDTO);
        }

        return userDTOList;
    }

}
