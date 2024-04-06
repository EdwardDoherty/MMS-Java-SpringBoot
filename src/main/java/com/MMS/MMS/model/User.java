package com.MMS.MMS.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


@Document("MMSData")
public class User implements Users {

    public ObjectId getUserID() {
        return userID;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public ArrayList<Expense> getUserExpenses(){
        return userExpenses;
    }

    public void setUserExpenses(){

    }

    public User(){

    }

    public User(String userName){
        this.userID = new ObjectId();
        this.userName = userName;
    }

    @Override
    public String toString(){
        return String.format(
                "User[userID=%s, userName='%s']",
                userID, userName
        );
    }

    @Id
    private ObjectId userID;
    private String userName;
    private ArrayList<Expense> userExpenses;

}
