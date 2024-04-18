package com.MMS.MMS.model;

import java.time.LocalDate;

public class ExpensePeriod {

    private final int dueDate;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public int getDueDate(){
        return this.dueDate;
    };
    public LocalDate getStartDate(){
        return this.startDate;
    };
    // Won't be used for all expenses.... mostly installment loans. I don't know where this belongs
    public LocalDate getEndDate(){
        return this.endDate;
    };

//    public ExpensePeriod(){
//        this.dueDate = 1;
//        this.startDate = LocalDate.now();
//        this.endDate = null;
//    }

    public ExpensePeriod(int dueDate, LocalDate startDate, LocalDate endDate){
        this.dueDate = Math.max(dueDate, 0);
        this.startDate = startDate != null ? startDate : LocalDate.now();
        this.endDate = endDate;
    }

}
