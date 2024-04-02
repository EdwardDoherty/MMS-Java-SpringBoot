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
    public void setTotalBalance(BigDecimal totalBal){
        this.totalBalance = totalBal;
    };
    public void setLiabilityType(LiabilityType liabType){
        this.liabilityType = liabType;
    };
    public void setInterestRate(BigDecimal interest){
        this.interestRate = interest;
    };

    // Constructor
    public Liability (
            String name,
            BigDecimal charge,
            int chargeFrequency,
            DateUtil dueDate,
            DateUtil startDate,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            BigDecimal lateFee,
            int gracePeriod,
            String notes,
            BigDecimal totalBalance,
            LiabilityType liabilityType,
            BigDecimal interestRate
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
            this.totalBalance = totalBalance;
            this.liabilityType = liabilityType;
            this.interestRate = interestRate;

    }

    //Private Variables
    private BigDecimal totalBalance;
    private LiabilityType liabilityType;
    private BigDecimal interestRate;

}
