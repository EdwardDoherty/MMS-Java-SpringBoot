package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;

import java.math.BigDecimal;

public class Expense implements Expenses {

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
    public Date getDueDate(){
        return dueDate;
    };
    public Date getStartDate(){
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
    };

    // Setters
    public void setName(String name){
        this.name = name;
    };
    public void setCharge(BigDecimal charge){
        this.charge = charge;
    };
    public void setChargeFrequency(int chargeFreq){
        this.chargeFrequency = chargeFreq;
    };
    public void setDueDate(Date dueDate){
        this.dueDate = dueDate;
    };
    public void setStartDate(Date startDate){
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
            BigDecimal charge,
            int chargeFrequency,
            Date dueDate,
            Date startDate,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            BigDecimal lateFee,
            int gracePeriod,
            String notes
    ){
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

    }


    // Private Variables
    private String name;
    private BigDecimal charge;
    private int chargeFrequency;
    private Date dueDate;
    private Date startDate;
    private ExpenseType expenseType;
    private PaymentStatus paymentStatus;
    private BigDecimal lateFee;
    private int gracePeriod;
    private String notes;


}
