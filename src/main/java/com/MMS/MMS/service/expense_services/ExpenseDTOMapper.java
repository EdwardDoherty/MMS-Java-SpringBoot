package com.MMS.MMS.service.expense_services;

import com.MMS.MMS.dto.ExpenseCreationDTO;
import com.MMS.MMS.dto.ExpenseDTO;
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

        ObjectId expenseID = expenseDTO.expenseID() != null ? expenseDTO.expenseID() : new ObjectId();
        ObjectId userID = expenseDTO.userID() != null ? expenseDTO.userID() : null;

        if(expenseDTO.userID() == null){ throw new BadExpenseDataException(); }

        String name = expenseDTO.name() != null ? expenseDTO.name() : "No name set";

        // This is bad, I shouldn't have to convert a BigDecimal to a string and then back to a BigDecimal
        // TODO: fix this
        Cost cost = expenseDTO.charge() != null ? new Cost(expenseDTO.charge().toString()) : null;

        ExpenseType expenseType = expenseDTO.expenseType() != null? expenseDTO.expenseType() : ExpenseType.UNSET;

        ChargeFrequency chargeFrequency = expenseDTO.chargeFrequency() != null ? expenseDTO.chargeFrequency() : ChargeFrequency.UNSET;

        String notes = expenseDTO.notes() != null ? expenseDTO.notes() : "No description";

        Delinquency delinquency = new Delinquency(
                expenseDTO.lateFee() != null ? expenseDTO.lateFee() : null,
                expenseDTO.gracePeriod(),
                expenseDTO.paymentStatus() != null ? expenseDTO.paymentStatus() : null);

        ExpensePeriod expensePeriod = new ExpensePeriod(
                expenseDTO.dueDate(), 
                expenseDTO.startDate() != null ? expenseDTO.startDate() : null,
                expenseDTO.endDate()   != null ? expenseDTO.endDate()   : null
        );

        return new FixedExpense(expenseID, userID, name, cost, expenseType, chargeFrequency, notes, delinquency, expensePeriod);

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
