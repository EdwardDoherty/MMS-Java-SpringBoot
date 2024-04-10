package com.MMS.MMS.enums;

import javax.lang.model.element.Element;

public enum ChargeFrequency {

    YEARLY("Yearly"),
    MONTHLY("Monthly"),
    BIMONTHLY("Bimonthly"),
    BIWEEKLY("Biweekly"),
    WEEKLY("Weekly"),
    DAILY("Daily"),
    UNSET("Unset");

    public final String label;

    private ChargeFrequency(String label){
        this.label = label;
    }

}
