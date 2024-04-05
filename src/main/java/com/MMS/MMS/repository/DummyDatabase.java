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
                        "20.00",
                        1,
                        1,
                        null,
                        ExpenseType.UTILITY,
                        PaymentStatus.UNPAID,
                        "0",
                        30,
                        "Test Expense. These are the notes! Exciting, right?"
                )
        );
        dummyDatabase.add(
                new Liability(
                        "Test Liability",
                        "45.00",
                        1,
                        15,
                        null,
                        ExpenseType.LIABILITY,
                        PaymentStatus.UNPAID,
                        "15",
                        0,
                        "Test Liability. Notes Notes Notes.",
                        "500",
                        LiabilityType.CREDITCARD,
                        "5.95"
                )
        );
        dummyDatabase.add(
                new InstallmentLoan(
                        "Test Installment",
                        "150.00",
                        1,
                        26,
                        null,
                        ExpenseType.LIABILITY,
                        PaymentStatus.UNPAID,
                        "45",
                        2,
                        "This is a test installment loan.",
                        "2500",
                        LiabilityType.INSTALLMENTLOAN,
                        "27.99",
                        null
                )
        );
    }

    private ArrayList<Expense> dummyDatabase = new ArrayList<Expense>();




};