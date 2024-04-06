package com.MMS.MMS.model;

import org.bson.types.ObjectId;

import java.util.ArrayList;

public interface Users {
    public ObjectId getUserID();

    public String getUserName();

    public void setUserName(String userName);

    public ArrayList<Expense> getUserExpenses();

    public void setUserExpenses();
}
