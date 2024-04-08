package com.MMS.MMS.repository;

import com.MMS.MMS.model.Expense;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.ArrayList;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    public ArrayList<Expense> findAllByUserID(ObjectId userID);

    public long count();

}
