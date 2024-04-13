package com.MMS.MMS.dto;

public class UserCreationDTO {

    private String userName;
    private String password;

    public String getUserName() { return userName; }

    public String getPassword() { return password; }

    public UserCreationDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
