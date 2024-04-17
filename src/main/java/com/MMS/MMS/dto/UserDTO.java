package com.MMS.MMS.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public record UserDTO(
        @Id
        ObjectId userID,
        String userName
    ) {


    @Override
    public ObjectId userID() {
        return userID;
    }

}
