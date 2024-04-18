package com.MMS.MMS.model;

import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class LiabilityExpense extends FixedExpense implements Liability {

    private final BigDecimal totalBalance;
    private final BigDecimal interestRate;

    public BigDecimal getTotalBalance(){
        return this.totalBalance;
    };
    public BigDecimal getInterestRate(){
        return this.interestRate;
    };

//    public LiabilityExpense() {
//        this.totalBalance = BigDecimal.ZERO;
//        this.interestRate = BigDecimal.ZERO;
//    }

    public LiabilityExpense(ObjectId expenseID,
                            ObjectId userID,
                            String name,
                            Cost cost,
                            ExpenseType expenseType,
                            ChargeFrequency chargeFrequency,
                            String notes,
                            Delinquency delinquency,
                            ExpensePeriod expensePeriod,
                            BigDecimal totalBalance,
                            BigDecimal interestRate){
        super(
                expenseID,
                userID,
                name,
                cost,
                expenseType,
                chargeFrequency,
                notes,
                delinquency,
                expensePeriod
        );
        this.totalBalance = totalBalance;
        this.interestRate = interestRate;
    }

}
