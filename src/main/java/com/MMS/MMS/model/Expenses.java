package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;

import java.math.BigDecimal;

public interface Expenses {

    public String getName();
    public BigDecimal getCharge();
    public int getChargeFrequency();
    public Date getDueDate();
    public Date getStartDate();
    public ExpenseType getExpenseType();
    public PaymentStatus getPaymentStatus();
    public BigDecimal getLateFee();
    public int getGracePeriod();
    public String getNotes();

}
