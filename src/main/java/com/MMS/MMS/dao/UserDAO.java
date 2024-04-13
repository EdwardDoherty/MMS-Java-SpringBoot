package com.MMS.MMS.dao;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.List;

public class UserDAO {

    @Id
    private final ObjectId userID;
    private final String userName;

    public ObjectId getUserID() { return userID; }

    public String getUserName() { return userName; }

    public UserDAO(ObjectId userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

}
