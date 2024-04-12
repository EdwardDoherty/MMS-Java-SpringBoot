package com.MMS.MMS.dto;

import com.MMS.MMS.model.User;
import com.MMS.MMS.repository.ExpenseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import java.util.List;

public class UserDTO {


    @Id
    private ObjectId userID;
    private String userName;
    private List<ExpenseDTO> userExpenses;

    public ObjectId getUserID() { return userID; }
    public void setUserID(ObjectId userID) { this.userID = userID; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public List<ExpenseDTO> getUserExpenses() { return this.userExpenses; }
    public void setUserExpenses(List<ExpenseDTO> userExpenses) { this.userExpenses = userExpenses; }

    public UserDTO(User user, List<ExpenseDTO> userExpenses) {
        this.userID = user.getUserID();
        this.userName = user.getUserName();
        this.userExpenses = userExpenses;
    }

}
