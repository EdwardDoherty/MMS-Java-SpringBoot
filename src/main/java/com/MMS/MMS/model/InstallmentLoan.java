package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.LiabilityType;
import com.MMS.MMS.enums.PaymentStatus;

import java.math.BigDecimal;

public class InstallmentLoan extends Liability {

    // Getters
    public Date getEndDate(){
        return endDate;
    };

    // Setter
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    };

    // Constructors
    public InstallmentLoan (
            String name,
            BigDecimal charge,
            int chargeFrequency,
            Date dueDate,
            Date startDate,
            ExpenseType expenseType,
            PaymentStatus paymentStatus,
            BigDecimal lateFee,
            int gracePeriod,
            String notes,
            BigDecimal totalBalance,
            LiabilityType liabilityType,
            BigDecimal interestRate,
            Date endDate
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
                notes,
                totalBalance,
                liabilityType,
                interestRate
        );
        this.endDate = endDate;
    }

    // Private Variables
    private Date endDate;


}
