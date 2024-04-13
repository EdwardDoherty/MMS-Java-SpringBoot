package com.MMS.MMS.dao;

import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.model.Cost;
import com.MMS.MMS.model.Delinquency;
import com.MMS.MMS.model.ExpensePeriod;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class ExpenseDAO {

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
    public Cost getCost(){ return this.cost; }
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

    public ExpenseDAO(
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
