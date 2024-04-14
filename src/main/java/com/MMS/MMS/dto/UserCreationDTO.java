package com.MMS.MMS.dto;

public class UserCreationDTO {

    private final String userName;
//    private String password;

    public String getUserName() { return userName; }

//    public String getPassword() { return password; }

    // We aren't currently using the password but this will be here when I need it.
//    public UserCreationDTO(String userName, String password) {
    public UserCreationDTO(String userName) {
        this.userName = userName;
        //this.password = password;
    }
}
