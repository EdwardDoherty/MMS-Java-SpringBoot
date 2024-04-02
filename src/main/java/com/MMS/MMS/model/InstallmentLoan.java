package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.LiabilityType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.util.DateUtil;

import java.math.BigDecimal;

public class InstallmentLoan extends Liability {

    // Getters
    public DateUtil getEndDate(){
        return endDate;
    };

    // Setter
    public void setEndDate(DateUtil endDate){
        this.endDate = endDate;
    };

    // Constructors
    public InstallmentLoan (
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
            BigDecimal interestRate,
            DateUtil endDate
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
    private DateUtil endDate;


}
