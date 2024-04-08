package com.MMS.MMS.repository;

import com.MMS.MMS.model.Expense;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepository extends MongoRepository<Expense, String> {

    public Expense findExpensesByUserID(ObjectId userID);

}
