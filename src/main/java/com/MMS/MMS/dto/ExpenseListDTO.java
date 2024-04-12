package com.MMS.MMS.dto;

import java.util.List;

public class ExpenseListDTO {

    private List<ExpenseDTO> expenses;

    public List<ExpenseDTO> getExpenses() { return expenses; }
    public void setExpenses(List<ExpenseDTO> expenses) {
        this.expenses = expenses;
    }

    public ExpenseListDTO(List<ExpenseDTO> expenses) {
        this.expenses = expenses;
    }

}
