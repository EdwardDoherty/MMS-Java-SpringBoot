package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
//
//@Document("Expenses")
public class OperatingExpense implements Expense {

    // Getters
    public ObjectId getExpenseID(){
        return this.expenseID;
    };
    public ObjectId getUserID(){
        return this.userID;
    }
    public String getName(){
        return name;
    };
    public BigDecimal getCharge(){
        return this.charge;
    };

    public int getChargeFrequency(){
        return this.chargeFrequency;
    };
    public int getDueDate(){
        return this.dueDate;
    };
    public LocalDate getStartDate(){
        return this.startDate;
    };
    public ExpenseType getExpenseType(){
        return this.expenseType;
    };
    public PaymentStatus getPaymentStatus(){
        return this.paymentStatus;
    };
    public BigDecimal getLateFee(){
        return this.lateFee;
    };
    public int getGracePeriod(){
        return this.gracePeriod;
    };
    public String getNotes(){
        return this.notes;
    }
    public BigDecimal getTotalBalance() {
        return null;
    }
    public BigDecimal getInterestRate() {
        return null;
    }
    public LocalDate getEndDate() {
        return this.endDate;
    }

    // Setters
    public void setUserID(ObjectId userID) {
        this.userID = userID;
    }

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
    public OperatingExpense(){
        this.expenseID = new ObjectId();
    }

    public OperatingExpense(ObjectId userID){
        this.expenseID = new ObjectId();
        this.userID = userID;
    }

    public OperatingExpense Create (ObjectId userID){
        return new OperatingExpense(userID);
    }

    public OperatingExpense(String name, String notes){
        this.expenseID = new ObjectId();
        this.name = name;
        this.notes = notes;
    }

    public OperatingExpense(
            ObjectId userID,
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
        this.expenseID = new ObjectId();
        this.userID = userID;
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
    public OperatingExpense(
            ObjectId userID,
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
        this.expenseID = new ObjectId();
        this.userID = userID;
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

    public OperatingExpense(
            ObjectId userID,
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
        this.expenseID = new ObjectId();
        this.userID = userID;
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
    @Id
    private ObjectId expenseID;
    private ObjectId userID;
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
