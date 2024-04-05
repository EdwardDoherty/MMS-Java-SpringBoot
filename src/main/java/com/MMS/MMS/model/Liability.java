package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.LiabilityType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.util.DateUtil;

import java.math.BigDecimal;

public class Liability extends Expense implements Liabilities {

    // Getters
    public BigDecimal getTotalBalance(){
        return totalBalance;
    };
    public LiabilityType getLiabilityType(){
        return liabilityType;
    };
    public BigDecimal getInterestRate(){
        return interestRate;
    };

    // Setters
    public void setTotalBalance(String totalBal){
        this.totalBalance = new BigDecimal(totalBal);
    };
    public void setLiabilityType(LiabilityType liabType){
        this.liabilityType = liabType;
    };
    public void setInterestRate(String interest){
        this.interestRate = new BigDecimal(interest);
    };

    // Constructor
    public Liability (
            String name,
            String charge,
            int chargeFrequency,
            int dueDate,
            int[] startDate,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            String lateFee,
            int gracePeriod,
            String notes,
            String totalBalance,
            LiabilityType liabilityType,
            String interestRate
    ){
        super(  name,
                charge,
                chargeFrequency,
                dueDate,
                startDate,
                expenseType,
                paymentStatus,
                lateFee,
                gracePeriod,
                notes);
            this.totalBalance = new BigDecimal(totalBalance);
            this.liabilityType = liabilityType;
            this.interestRate = new BigDecimal(interestRate);

    }

    //Private Variables
    private BigDecimal totalBalance;
    private LiabilityType liabilityType;
    private BigDecimal interestRate;

}
