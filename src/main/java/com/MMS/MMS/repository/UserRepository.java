package com.MMS.MMS.repository;

import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.ArrayList;

public interface UserRepository extends MongoRepository<User, String> {
    @Query("{name:'?0'}")
    User findUserByName(String name);

    @Query(value="{userExpenses: '?0'}", fields="{'name':  1, 'userExpenses' :  1}")
    ArrayList<Expense> findAll(Expense expense);

    public long count();



}
