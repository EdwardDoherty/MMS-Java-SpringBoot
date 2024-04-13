package com.MMS.MMS.repository;

import com.MMS.MMS.dao.UserDAO;
import com.MMS.MMS.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDAO, String> {

    public Optional<User> findUserByUserName(String userName);

    public Optional<User> findUserByUserID(ObjectId userID);

}
