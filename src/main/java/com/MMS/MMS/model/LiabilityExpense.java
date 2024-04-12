package com.MMS.MMS.model;

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

    public LiabilityExpense() {
        this.totalBalance = BigDecimal.ZERO;
        this.interestRate = BigDecimal.ZERO;
    }

    public LiabilityExpense(BigDecimal totalBalance, BigDecimal interestRate){
        this.totalBalance = totalBalance;
        this.interestRate = interestRate;
    }

}
