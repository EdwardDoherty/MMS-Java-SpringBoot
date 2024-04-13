package com.MMS.MMS.dto;

import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.List;

public class UserDTO {


    @Id
    private final ObjectId userID;
    private final String userName;

    public ObjectId getUserID() { return userID; }

    public String getUserName() { return userName; }

    public UserDTO(ObjectId userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

}
