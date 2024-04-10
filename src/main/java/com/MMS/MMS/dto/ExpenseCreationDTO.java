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
    private ObjectId expenseID;
    private ObjectId userID;
    private String name;
    private String charge;
    private String chargeFrequency;
    private int dueDate;
    private LocalDate startDate;
    private String expenseType;
    private String paymentStatus;
    private String lateFee;
    private int gracePeriod;
    private String notes;
    private String totalBalance;
    private String interestRate;
    private LocalDate endDate;

    public ObjectId getExpenseID() {return expenseID;}
    public void setExpenseID(ObjectId expenseID) {this.expenseID = expenseID;}

    public ObjectId getUserID() {return userID;}
    public void setUserID(ObjectId userID) {this.userID = userID;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getCharge() {return charge;}
    public void setCharge(String charge) {this.charge = charge;}

    public String getChargeFrequency() {return chargeFrequency;}
    public void setChargeFrequency(String chargeFrequency) {this.chargeFrequency = chargeFrequency;}

    public int getDueDate() {return dueDate;}
    public void setDueDate(int dueDate) {this.dueDate = dueDate;}

    public LocalDate getStartDate() {return startDate;}
    public void setStartDate(LocalDate startDate) {this.startDate = startDate;}

    public String getExpenseType() {return expenseType;}
    public void setExpenseType(String expenseType) {this.expenseType = expenseType;}

    public String getPaymentStatus() {return paymentStatus;}
    public void setPaymentStatus(String paymentStatus) {this.paymentStatus = paymentStatus;}

    public String getLateFee() {return lateFee;}
    public void setLateFee(String lateFee) {this.lateFee = lateFee;}

    public int getGracePeriod() {return gracePeriod;}
    public void setGracePeriod(int gracePeriod) {this.gracePeriod = gracePeriod;}

    public String getNotes() {return notes;}
    public void setNotes(String notes) {this.notes = notes;}

    public String getTotalBalance() {return totalBalance;}
    public void setTotalBalance(String totalBalance) {this.totalBalance = totalBalance;}

    public String getInterestRate() {return interestRate;}
    public void setInterestRate(String interestRate) {this.interestRate = interestRate;}

    public LocalDate getEndDate() {return endDate;}
    public void setEndDate(LocalDate endDate) {this.endDate = endDate;}

    public ExpenseCreationDTO(){
        this.expenseID = new ObjectId();
        this.chargeFrequency = "Unset");
    }

    public ExpenseCreationDTO(ObjectId userID){
        this.expenseID = new ObjectId();
        this.userID = userID;
    }

    public ExpenseCreationDTO(String name, String notes){
        this.expenseID = new ObjectId();
        this.name = name;
        this.notes = notes;
    }

    public ExpenseCreationDTO(
            ObjectId userID,
            String name,
            String charge,
            String chargeFrequency,
            int dueDate,
            LocalDate startDate,
            String expenseType,
            String paymentStatus,
            String lateFee,
            int gracePeriod,
            String notes
    ){
        this.expenseID = new ObjectId();
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

    }
    public ExpenseCreationDTO(
            ObjectId userID,
            String name,
            String charge,
            String chargeFrequency,
            int dueDate,
            LocalDate startDate,
            String expenseType,
            String paymentStatus,
            String lateFee,
            int gracePeriod,
            String notes,
            String totalBalance,
            String interestRate
    ){
        this.expenseID = new ObjectId();
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
        this.totalBalance = totalBalance;
        this.interestRate = interestRate;
    }
}
