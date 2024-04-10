package com.MMS.MMS.controllers.mappers;

import com.MMS.MMS.dto.ExpenseCreationDTO;
import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.OperatingExpense;
import org.bson.types.ObjectId;

import java.time.LocalDate;

public class ExpenseMapper {

    public ExpenseDTO toDTO(Expense expense) {

        ObjectId userID = expense.getUserID();
        String name = expense.getName();
        String charge = expense.getCharge().toString();
        String chargeFrequency = expense.getChargeFrequency().label;
        int dueDate = expense.getDueDate();
        LocalDate startDate = expense.getStartDate();
        String expenseType = expense.getExpenseType().label;
        String paymentStatus = expense.getPaymentStatus().label;
        String lateFee = expense.getLateFee().toString();
        int gracePeriod = expense.getGracePeriod();
        String notes = expense.getNotes();
        String totalBalance = expense.getTotalBalance().toString();
        String interestRate = expense.getInterestRate().toString();
        LocalDate endDate = expense.getEndDate();

        return new ExpenseDTO(
                userID,
                name,
                charge,
                chargeFrequency,
                dueDate,
                startDate,
                expenseType,
                paymentStatus,
                lateFee,
                gracePeriod,
                notes,
                totalBalance,
                interestRate,
                endDate
        );
    }

    public Expense toExpense(ExpenseCreationDTO expenseDTO) {
        // Do some logic to choose which flavor of expense to create?
        return new OperatingExpense(expenseDTO.getUserID())
    }

}
