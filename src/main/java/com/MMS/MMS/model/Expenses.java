package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

public interface Expenses {

    public String getName();
    public BigDecimal getCharge();
    public int getChargeFrequency();
    public int getDueDate();
    public int[] getStartDate();
    public ExpenseType getExpenseType();
    public PaymentStatus getPaymentStatus();
    public BigDecimal getLateFee();
    public int getGracePeriod();
    public String getNotes();

}
