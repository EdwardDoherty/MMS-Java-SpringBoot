package com.MMS.MMS.controllers;

import com.MMS.MMS.dto.ExpenseDTO;
import com.MMS.MMS.dto.ExpenseListDTO;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.repository.ExpenseRepository;
import com.MMS.MMS.service.expense_services.ExpenseDTOMapper;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ExpenseGETController {

    @Autowired
    private ExpenseRepository expenseRepository;

    @GetMapping("/getExpenseList")
    @ResponseBody
    public ExpenseListDTO getExpenseDTOsByUserID(ObjectId userID) {
        List<Expense> expenses = expenseRepository.findAllByUserID(userID);

        List<ExpenseDTO> expenseDTOList = new ArrayList<ExpenseDTO>();
        // This is stupid but it works for now. I'm converting it back and forth but whatever
        expenses.forEach((expense) -> expenseDTOList.add(ExpenseDTOMapper.toDTO(expense)) );

        return new ExpenseListDTO(expenseDTOList);
    }

}
