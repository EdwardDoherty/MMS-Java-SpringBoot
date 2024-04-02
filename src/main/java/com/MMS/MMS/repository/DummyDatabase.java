package com.MMS.MMS.repository;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.LiabilityType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.util.DateUtil;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.InstallmentLoan;
import com.MMS.MMS.model.Liability;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DummyDatabase {

    public DummyDatabase(){
        BuildArrayList();
    }

    public ArrayList<Expense> getDummyDatabase(){
        return dummyDatabase;
    };

    public void BuildArrayList(){
        dummyDatabase.add(
                new Expense(
                        "Test Expense",
                        new BigDecimal("20.00"),
                        1,
                        new DateUtil(1),
                        new DateUtil(0),
                        ExpenseType.UTILITY,
                        PaymentStatus.UNPAID,
                        new BigDecimal("0"),
                        30,
                        "Test Expense. These are the notes! Exciting, right?"
                ));
        dummyDatabase.add(
                new Liability(
                        "Test Liability",
                        new BigDecimal("45.00"),
                        1,
                        new DateUtil(15),
                        new DateUtil(0),
                        ExpenseType.LIABILITY,
                        PaymentStatus.UNPAID,
                        new BigDecimal("15"),
                        0,
                        "Test Liability. Notes Notes Notes.",
                        new BigDecimal("500"),
                        LiabilityType.CREDITCARD,
                        new BigDecimal("5.95")
                )
        );
        dummyDatabase.add(
            new InstallmentLoan(
                    "Test Installment",
                    new BigDecimal("150.00"),
                    1,
                    new DateUtil(26),
                    new DateUtil(0),
                    ExpenseType.LIABILITY,
                    PaymentStatus.UNPAID,
                    new BigDecimal("45"),
                    2,
                    "This is a test installment loan.",
                    new BigDecimal("2500"),
                    LiabilityType.INSTALLMENTLOAN,
                    new BigDecimal("27.99"),
                    new DateUtil(30)
            )
        );
    }

    private ArrayList<Expense> dummyDatabase = new ArrayList<Expense>();




};