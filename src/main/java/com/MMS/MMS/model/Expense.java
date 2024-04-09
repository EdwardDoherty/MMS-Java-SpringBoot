package com.MMS.MMS.model;

import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Document("Expenses")
public interface Expense {

    public ObjectId getExpenseID();
    public ObjectId getUserID();
    public String getName();
    public BigDecimal getCharge();
    public ChargeFrequency getChargeFrequency();
    public int getDueDate();
    public LocalDate getStartDate();
    public ExpenseType getExpenseType();
    public PaymentStatus getPaymentStatus();
    public BigDecimal getLateFee();
    public int getGracePeriod();
    public String getNotes();
    public BigDecimal getTotalBalance();
    public BigDecimal getInterestRate();
    public LocalDate getEndDate();


}
