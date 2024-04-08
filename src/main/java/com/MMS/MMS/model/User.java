package com.MMS.MMS.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;

//@ModelAttribute("user")
@Document("Users")
public class User {

    public ObjectId getUserID() {
        return this.userID;
    }

    public String getUserName(){
        return this.userName;
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

}
