package com.MMS.MMS.dto;

import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.model.Cost;
import com.MMS.MMS.model.Delinquency;
import com.MMS.MMS.model.ExpensePeriod;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
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
    public Cost getCost(){
        return this.cost;
    }
    public BigDecimal getCostValue(){
        return this.cost.getCost();
    }
    public ExpenseType getExpenseType(){
        return this.expenseType;
    }
    public String getExpenseTypeLabel(){
        return this.expenseType.label;
    };
    public ChargeFrequency getChargeFrequency(){
        return this.chargeFrequency;
    }
    public String getChargeFrequencyLabel(){
        return this.chargeFrequency.label;
    };
    public String getNotes(){
        return this.notes;
    };
    public Delinquency getDelinquency(){ return this.delinquency; };
    public ExpensePeriod getExpensePeriod(){ return this.expensePeriod; };

    public PaymentStatus getPaymentStatus(){
        return this.delinquency.getPaymentStatus();
    };
    public String getPaymentStatusLabel(){
        return this.delinquency.getPaymentStatus().label;
    }
    public int getGracePeriod(){
        return this.delinquency.getGracePeriod();
    };
    public BigDecimal getLateFee(){
        return this.delinquency.getLateFee();
    };
    public int getDueDate(){
        return this.expensePeriod.getDueDate();
    };
    public LocalDate getStartDate(){
        return this.expensePeriod.getStartDate();
    };
    public LocalDate getEndDate(){
        return this.expensePeriod.getEndDate();
    };


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
        this.name = name != null ? name : "No Name";
        this.cost = cost != null ? cost : new Cost("0");
        this.expenseType = expenseType != null ? expenseType : ExpenseType.UNSET;
        this.chargeFrequency = chargeFrequency != null ? chargeFrequency : ChargeFrequency.UNSET;
        this.notes = notes != null ? notes : "No Description";

        // I don't like this.... Factory constructor might be better?
        this.delinquency = delinquency != null ? delinquency : new Delinquency(null, 0, null);
        this.expensePeriod = expensePeriod != null ? expensePeriod : new ExpensePeriod(0, null, null);
    }

    @Override
    public java.lang.String toString() {
        return super.toString();
    }
}
