package com.MMS.MMS.dto;

import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.model.Cost;
import com.MMS.MMS.model.Delinquency;
import com.MMS.MMS.model.ExpensePeriod;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

public class ExpenseDTO {

    @Id
    private final ObjectId expenseID;
    private final ObjectId userID;
    private final String name;
    private final Cost cost;
    private final ExpenseType expenseType;
    private final ChargeFrequency chargeFrequency;
    private final String notes;
    private final Delinquency delinquency;
    private final ExpensePeriod expensePeriod;


    public ObjectId getExpenseID(){
        return this.expenseID;
    };
    public ObjectId getUserID(){
        return this.userID;
    };
    public String getName(){
        return this.name;
    };
    public ExpenseType getExpenseType(){
        return this.expenseType;
    };
    public ChargeFrequency getChargeFrequency(){
        return this.chargeFrequency;
    };
    public String getNotes(){
        return this.notes;
    };
    public Delinquency getDelinquency(){ return this.delinquency; };
    public ExpensePeriod getExpensePeriod(){ return this.expensePeriod; };


    // All args constructor
    public ExpenseDTO(
            ObjectId expenseID,
            ObjectId userID,
            String name,
            Cost cost,
            ExpenseType expenseType,
            ChargeFrequency chargeFrequency,
            String notes,
            Delinquency delinquency,
            ExpensePeriod expensePeriod){
        this.expenseID = expenseID;
        this.userID = userID;
        this.name = name;
        this.cost = cost;
        this.expenseType = expenseType;
        this.chargeFrequency = chargeFrequency;
        this.notes = notes;
        this.delinquency = delinquency;
        this.expensePeriod = expensePeriod;
    }

}
