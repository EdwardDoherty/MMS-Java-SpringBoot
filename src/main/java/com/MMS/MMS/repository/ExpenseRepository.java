package com.MMS.MMS.repository;

import com.MMS.MMS.model.Expense;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    public List<Expense> findAllByUserID(ObjectId userID);


}
