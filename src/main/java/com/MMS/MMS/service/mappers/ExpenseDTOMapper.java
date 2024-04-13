package com.MMS.MMS.service.mappers;

import com.MMS.MMS.dto.ExpenseCreationDTO;
import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.ExpenseListDTO;
import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.model.*;
import com.MMS.MMS.repository.ExpenseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseMapper {

    @Autowired
    private ExpenseRepository expenseRepository;

    public static ExpenseDTO toDTO(Expense expense) {

        ObjectId expenseID = expense.getExpenseID();
        ObjectId userID = expense.getUserID();
        String name = expense.getName();
        Cost cost = expense.getCost();
        ExpenseType expenseType = expense.getExpenseType();
        ChargeFrequency chargeFrequency = expense.getChargeFrequency();
        String notes = expense.getNotes();
        Delinquency delinquency = expense.getDelinquency();
        ExpensePeriod expensePeriod = expense.getExpensePeriod();

        return new ExpenseDTO(
                expenseID,
                userID,
                name,
                cost,
                expenseType,
                chargeFrequency,
                notes,
                delinquency,
                expensePeriod
        );
    }

    public ExpenseListDTO getExpenseDTOsByUserID(ObjectId userID) {
        List<Expense> expenses = expenseRepository.findAllByUserID(userID);

        List<ExpenseDTO> expenseDTOList = new ArrayList<ExpenseDTO>();
        // This is stupid but it works for now. I'm converting it back and forth but whatever
        expenses.forEach((expense) -> expenseDTOList.add(ExpenseMapper.toDTO(expense)) );

        return new ExpenseListDTO(expenseDTOList);
    }

    public FixedExpense toExpense(ExpenseCreationDTO expenseDTO) {
        // Do some logic to choose which flavor of expense to create?
        // Need to check if it's a fixed expense or a liability expense first....

        ObjectId userID = expenseDTO.getUserID();
        String notes = expenseDTO.getNotes();
        return new FixedExpense();
    }

}
