package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Expense {

    // Getters
    public String getName(){
        return name;
    };
    public BigDecimal getCharge(){
        return charge;
    };

    public int getChargeFrequency(){
        return chargeFrequency;
    };
    public int getDueDate(){
        return dueDate;
    };
    public LocalDate getStartDate(){
        return startDate;
    };
    public ExpenseType getExpenseType(){
        return expenseType;
    };
    public PaymentStatus getPaymentStatus(){
        return paymentStatus;
    };
    public BigDecimal getLateFee(){
        return lateFee;
    };
    public int getGracePeriod(){
        return gracePeriod;
    };
    public String getNotes(){
        return notes;
    }
    public BigDecimal getTotalBalance() {
        return null;
    }
    public BigDecimal getInterestRate() {
        return null;
    }



    // Setters
    public void setName(String name){
        this.name = name;
    };
    public void setCharge(String charge){
        this.charge = new BigDecimal(charge);
    };
    public void setChargeFrequency(int chargeFreq){
        this.chargeFrequency = chargeFreq;
    };
    public void setDueDate(int dueDate){
        this.dueDate = dueDate;
    };
    public void setStartDate(LocalDate startDate){
        this.startDate = startDate;
    };
    public void setExpenseType(ExpenseType expenseType){
        this.expenseType = expenseType;
    };
    public void setPaymentStatus(PaymentStatus payStat){
        this.paymentStatus = payStat;
    };
    public void setLateFee(BigDecimal lateFee){
        this.lateFee = lateFee;
    };
    public void setGracePeriod(int gracePeriod){
        this.gracePeriod = gracePeriod;
    };
    public void setNotes(String notes){
        this.notes = notes;
    };

    // Constructor
    public Expense(
            String name,
            String charge,
            int chargeFrequency,
            int dueDate,
            LocalDate startDate,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            String lateFee,
            int gracePeriod,
            String notes
    ){
        this.name = name;
        this.charge = new BigDecimal(charge);
        this.chargeFrequency = chargeFrequency;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.expenseType = expenseType;
        this.paymentStatus = paymentStatus;
        this.lateFee = new BigDecimal(lateFee);
        this.gracePeriod = gracePeriod;
        this.notes = notes;

    }
    public Expense(
            String name,
            String charge,
            int chargeFrequency,
            int dueDate,
            LocalDate startDate,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            String lateFee,
            int gracePeriod,
            String notes,
            String totalBalance,
            String interestRate
    ){
        this.name = name;
        this.charge = new BigDecimal(charge);
        this.chargeFrequency = chargeFrequency;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.expenseType = expenseType;
        this.paymentStatus = paymentStatus;
        this.lateFee = new BigDecimal(lateFee);
        this.gracePeriod = gracePeriod;
        this.notes = notes;
        this.totalBalance = new BigDecimal(totalBalance);
        this.interestRate = new BigDecimal(interestRate);
    }

    public Expense(
            String name,
            String charge,
            int chargeFrequency,
            int dueDate,
            LocalDate startDate,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            String lateFee,
            int gracePeriod,
            String notes,
            String totalBalance,
            String interestRate,
            LocalDate endDate
    ){
        this.name = name;
        this.charge = new BigDecimal(charge);
        this.chargeFrequency = chargeFrequency;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.expenseType = expenseType;
        this.paymentStatus = paymentStatus;
        this.lateFee = new BigDecimal(lateFee);
        this.gracePeriod = gracePeriod;
        this.notes = notes;
        this.totalBalance = new BigDecimal(totalBalance);
        this.interestRate = new BigDecimal(interestRate);
        this.endDate = endDate;
    }


    // Private Variables
    private String name;
    private BigDecimal charge;
    private int chargeFrequency;
    private int dueDate;
    private LocalDate startDate;
    private ExpenseType expenseType;
    private PaymentStatus paymentStatus;
    private BigDecimal lateFee;
    private int gracePeriod;
    private String notes;
    private BigDecimal totalBalance;
    private BigDecimal interestRate;
    private LocalDate endDate;
}
