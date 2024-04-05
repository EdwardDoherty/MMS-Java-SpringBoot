package com.MMS.MMS.repository;

import com.MMS.MMS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

    public User findUserByUserName(String userName);

    //public List<User> findAll();

    public long count();



}
