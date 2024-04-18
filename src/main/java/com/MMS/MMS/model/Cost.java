package com.MMS.MMS.model;

import java.math.BigDecimal;

public class Cost {

    private final BigDecimal cost;

    public BigDecimal getCost(){
        return this.cost;
    };

//    public Cost(){
//        this.cost = new BigDecimal(0);
//    }

    public Cost(String cost){
        this.cost = cost != null ? new BigDecimal(cost): new BigDecimal(0);
    }


}
