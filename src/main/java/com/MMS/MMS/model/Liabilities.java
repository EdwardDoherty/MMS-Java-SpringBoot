package com.MMS.MMS.model;

import com.MMS.MMS.enums.LiabilityType;

import java.math.BigDecimal;

public interface Liabilities extends Expenses {

    public BigDecimal getTotalBalance();
    public LiabilityType getLiabilityType();
    public BigDecimal getInterestRate();


}
