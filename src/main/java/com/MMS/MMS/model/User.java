package com.MMS.MMS.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

@Document("Users")
public class User {

    public ObjectId getUserID() {
        return this.userID;
    }

    public String getUserName(){
        return this.userName;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public User(){
        this.userID = new ObjectId();
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

}
