package com.MMS.MMS.model;


public class ErrorLoginMessage implements Error {

    public String getErrorMessage() {
        return errorMessage;
    }

    public Boolean isError(){
        if(errorMessage != null){
            return true;
        }
        else {
            return false;
        }
    }

    public ErrorLoginMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }

    private String errorMessage;

}
