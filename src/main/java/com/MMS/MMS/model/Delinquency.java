package com.MMS.MMS.model;

import com.MMS.MMS.enums.PaymentStatus;

import java.math.BigDecimal;

public class Delinquency {

    private final BigDecimal lateFee;
    private final int gracePeriod;
    private final PaymentStatus paymentStatus;


    public PaymentStatus getPaymentStatus(){
        return this.paymentStatus;
    };

    public int getGracePeriod(){
        return this.gracePeriod;
    };

    public BigDecimal getLateFee(){
        return this.lateFee;
    };

//    public Delinquency(){
//        this.paymentStatus = PaymentStatus.UNPAID;
//        this.gracePeriod = 0;
//        this.lateFee = BigDecimal.ZERO;
//    }

    public Delinquency(BigDecimal lateFee, int gracePeriod, PaymentStatus paymentStatus){
        this.lateFee = lateFee != null ? lateFee : BigDecimal.ZERO;
        this.gracePeriod = Math.max(gracePeriod, 0);
        this.paymentStatus = paymentStatus != null ? paymentStatus : PaymentStatus.UNPAID;
    }


}
