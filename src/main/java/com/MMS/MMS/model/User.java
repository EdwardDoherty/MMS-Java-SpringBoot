package com.MMS.MMS.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document("MMSData")
public class User implements Users {

    public String getUserID() {
        return userID;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(){

    }

    public ArrayList<Expense> getUserExpenses(){
        return userExpenses;
    }

    public void setUserExpenses(){

    }

    public User(String userID, String userName, ArrayList<Expense> userExpenses){
        this.userID = userID;
        this.userName = userName;
        this.userExpenses = userExpenses;
    }

    @Id
    private String userID;
    private String userName;
    private ArrayList<Expense> userExpenses;

}
