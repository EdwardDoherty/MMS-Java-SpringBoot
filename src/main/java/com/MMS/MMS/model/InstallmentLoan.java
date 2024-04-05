package com.MMS.MMS.model;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.LiabilityType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.util.DateUtil;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

public class InstallmentLoan extends Liability {

    // Getters
    public int[] getEndDate(){
        return endDate;
    };

    // Setter
    public void setEndDate(int[] endDate){
        this.endDate = endDate;
    };

    // Constructors
    public InstallmentLoan (
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
            String interestRate,
            int[] endDate
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
    private int[] endDate = null;


}
