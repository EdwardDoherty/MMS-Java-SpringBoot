package com.MMS.MMS.dto;

import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseCreationDTO {

    @Id
    private final ObjectId expenseID;
    private final ObjectId userID;
    private final String name;
    private final BigDecimal charge;
    private final ChargeFrequency chargeFrequency;
    private final ExpenseType expenseType;
    private final PaymentStatus paymentStatus;
    private final String notes;
    private final BigDecimal lateFee;
    private final int gracePeriod;
    private final int dueDate;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final BigDecimal totalBalance;
    private final BigDecimal interestRate;

    public ObjectId getExpenseID() {return expenseID;}
    public ObjectId getUserID() {return userID;}
    public String getName() {return name;}
    public BigDecimal getCharge() {return charge;}
    public ChargeFrequency getChargeFrequency() {return chargeFrequency;}
    public ExpenseType getExpenseType() {return expenseType;}
    public PaymentStatus getPaymentStatus() {return paymentStatus;}
    public String getNotes() {return notes;}
    public BigDecimal getLateFee() {return lateFee;}
    public int getGracePeriod() {return gracePeriod;}
    public int getDueDate() {return dueDate;}
    public LocalDate getStartDate() {return startDate;}
    public LocalDate getEndDate() {return endDate;}
    public BigDecimal getTotalBalance() {return totalBalance;}
    public BigDecimal getInterestRate() {return interestRate;}


    public ExpenseCreationDTO(
            ObjectId expenseID,
            ObjectId userID,
            String name,
            BigDecimal charge,
            ChargeFrequency chargeFrequency,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            String notes,
            BigDecimal lateFee,
            int gracePeriod,
            int dueDate,
            LocalDate startDate,
            LocalDate endDate,
            BigDecimal totalBalance,
            BigDecimal interestRate
    ){
        this.expenseID = expenseID;
        this.userID = userID;
        this.name = name;
        this.charge = charge;
        this.chargeFrequency = chargeFrequency;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.expenseType = expenseType;
        this.paymentStatus = paymentStatus;
        this.lateFee = lateFee;
        this.gracePeriod = gracePeriod;
        this.notes = notes;
        this.endDate = endDate;
        this.totalBalance = totalBalance;
        this.interestRate = interestRate;
    }
}
