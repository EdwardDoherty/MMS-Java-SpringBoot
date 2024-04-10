package com.MMS.MMS.enums;

public enum PaymentStatus {

    PAID("Paid"),
    UNPAID("Unpaid"),
    LATE("Late"),
    NOT_DUE("Not Due");

    public final String label;

    private PaymentStatus(String label){
        this.label = label;
    }

}
