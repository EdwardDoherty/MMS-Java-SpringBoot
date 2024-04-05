package com.MMS.MMS.model;

import java.util.ArrayList;

public interface Users {
    public String getUserID();

    public String getUserName();

    public void setUserName();

    public ArrayList<Expense> getUserExpenses();

    public void setUserExpenses();
}
