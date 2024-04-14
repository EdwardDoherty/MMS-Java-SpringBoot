package com.MMS.MMS.repository;

import com.MMS.MMS.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    // Responsible for storing and retrieving some set of data
    // If code is relating to storage or retrieval from the database, it goes in the repository.

    public User findUserByUserName(String userName);

    public User findUserByUserID(ObjectId userID);

    public void deleteUserByUserID(ObjectId userID);
}
