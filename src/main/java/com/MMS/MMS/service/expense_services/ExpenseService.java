package com.MMS.MMS.service.expense_services;

import com.MMS.MMS.model.Expense;
import com.MMS.MMS.repository.DatabaseAccessException;
import com.MMS.MMS.repository.ExpenseRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    // No DTOs allowed here!

    private final ExpenseRepository expenseRepo;


    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepo = expenseRepository;
    }

    public Expense getExpenseByExpenseId(ObjectId expenseId) throws ExpenseNotFoundException {
        Expense expense = expenseRepo.findExpenseByExpenseID(expenseId);

        if(expense == null){
            throw new ExpenseNotFoundException();
        }
        return expense;
    }

    public List<Expense> getExpensesByUserId(ObjectId expenseId) throws ExpenseNotFoundException {

        return expenseRepo.findAllByUserID(expenseId);
    }

    public void deleteExpenseById(ObjectId expenseID) throws ExpenseNotFoundException {
        Expense expense = getExpenseByExpenseId(expenseID);
        expenseRepo.deleteExpenseByExpenseID(expense.getExpenseID());
    }

    public void saveExpense(Expense expense) throws BadExpenseDataException {
        try {
            expenseRepo.save(expense);
        }
        catch(Exception e){
            throw new BadExpenseDataException();
        }
    }

    public List<Expense> getAllExpenses() throws DatabaseAccessException {
        try {
            return expenseRepo.findAll();
        }
        catch(Exception e){
            throw new DatabaseAccessException();
        }
    }
}
