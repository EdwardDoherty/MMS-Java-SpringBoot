package com.MMS.MMS.enums;

public enum ExpenseType {

    UTILITY("Utility"),
    INSURANCE("Insurance"),
    STREAMING("Streaming"),
    MISCELLANEOUS("Miscellaneous"),
    INSTALLMENT_LOAN("Installment Loan"),
    CREDIT_CARD("Credit Card"),
    UNSET("Unset");

    public final String label;

    private ExpenseType(String label){
        this.label = label;
    }

}
