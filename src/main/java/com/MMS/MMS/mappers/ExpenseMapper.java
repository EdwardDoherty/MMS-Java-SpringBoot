package com.MMS.MMS.mappers;

import com.MMS.MMS.dto.ExpenseCreationDTO;
import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.ExpenseListDTO;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.OperatingExpense;
import com.MMS.MMS.repository.ExpenseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ExpenseMapper {

    @Autowired
    private ExpenseRepository expenseRepository;

    public static ExpenseDTO toDTO(Expense expense) {

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

    public ExpenseListDTO getExpenseDTOsByUserID(ObjectId userID) {
        List<Expense> expenses = expenseRepository.findAllByUserID(userID);

        List<ExpenseDTO> expenseDTOList = new ArrayList<ExpenseDTO>();
        // This is stupid but it works for now. I'm converting it back and forth but whatever
        expenses.forEach((expense) -> expenseDTOList.add(ExpenseMapper.toDTO(expense)) );

        return new ExpenseListDTO(expenseDTOList);
    }

    public Expense toExpense(ExpenseCreationDTO expenseDTO) {
        // Do some logic to choose which flavor of expense to create?
        ObjectId userID = expenseDTO.getUserID();
        String notes = expenseDTO.getNotes();
        return new OperatingExpense();
    }

}
