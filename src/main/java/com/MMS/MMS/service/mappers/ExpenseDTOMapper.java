package com.MMS.MMS.service.mappers;

import com.MMS.MMS.dto.ExpenseCreationDTO;
import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.ExpenseListDTO;
import com.MMS.MMS.dto.ExpenseQuickCreateDTO;
import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.model.*;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseDTOMapper {

    // Waiting for ExpenseController


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

    public List<ExpenseDTO> convertListToDTO(List<Expense> expenseList) {

        List<ExpenseDTO> expenseDTOList = new ArrayList<ExpenseDTO>();
        // This is stupid but it works for now. I'm converting it back and forth but whatever
        expenseList.forEach((expense) -> expenseDTOList.add(toDTO(expense)));

        return expenseDTOList;
    }

    public FixedExpense toExpense(ExpenseCreationDTO expenseDTO) {
        // Do some logic to choose which flavor of expense to create?
        // Need to check if it's a fixed expense or a liability expense first....

        ObjectId userID = expenseDTO.userID();
        String notes = expenseDTO.notes();
        return new FixedExpense();
    }

    public ExpenseQuickCreateDTO quickCreateDTO(ObjectId userID){
        return new ExpenseQuickCreateDTO(
                new ObjectId(),
                userID,
                "No name added",
                null,
                "No description");
    }

    public ExpenseCreationDTO quickCreateToFullDTO(ExpenseQuickCreateDTO quickAddDTO){
        return new ExpenseCreationDTO(
                quickAddDTO.expenseID(),
                quickAddDTO.userID(),
                quickAddDTO.name(),
                quickAddDTO.charge(),
                ChargeFrequency.UNSET,
                ExpenseType.UNSET,
                PaymentStatus.UNPAID,
                quickAddDTO.notes(),
                null,
                0,
                0,
                null,
                null,
                null,
                null
                );
    }

}
