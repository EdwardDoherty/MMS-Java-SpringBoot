package com.MMS.MMS.repository;

import com.MMS.MMS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findUserByUserName(String userName);

}
