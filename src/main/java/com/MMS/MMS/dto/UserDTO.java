package com.MMS.MMS.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;

public class UserDTO {

    @Id
    private ObjectId userID;
    private String userName;
    private ArrayList<ExpenseDTO> userExpenses;

    public ObjectId getUserID() { return userID; }
    public void setUserID(ObjectId userID) { this.userID = userID; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public ArrayList<ExpenseDTO> getUserExpenses() { return userExpenses; }
    public void setUserExpenses(ArrayList<ExpenseDTO> userExpenses) { this.userExpenses = userExpenses; }

    public UserDTO(ObjectId userID, String userName, ArrayList<ExpenseDTO> userExpenses) {
        this.userID = userID;
        this.userName = userName;
        this.userExpenses = userExpenses;
    }

}
