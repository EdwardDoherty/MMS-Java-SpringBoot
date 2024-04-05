package com.MMS.MMS.repository;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
//
//public class CreateUser {
////    @Autowired
////    UserRepository userRepository;
//
//    public User createUser() {
//        ArrayList<Expense> userExpense = new ArrayList<Expense>();
//        userExpense.add(new Expense(
//                "Test Expense",
//                "20.00",
//                1,
//                1,
//                null,
//                ExpenseType.UTILITY,
//                PaymentStatus.UNPAID,
//                "0",
//                30,
//                "Test expense. Added to database from java"
//        ));
//        userExpense.add(new Expense(
//                "Test Liability",
//                "45.00",
//                1,
//                15,
//                null,
//                ExpenseType.CREDITCARD,
//                PaymentStatus.UNPAID,
//                "15.00",
//                0,
//                "Test Liability. Added to database from java",
//                "500",
//                "5.95",
//                null
//        ));
//        userExpense.add(new Expense(
//                "Test Installment Loan",
//                "150.00",
//                1,
//                26,
//                null,
//                ExpenseType.INSTALLMENTLOAN,
//                PaymentStatus.UNPAID,
//                "45.00",
//                2,
//                "Test Installment Loan. Added to database from java",
//                "2500",
//                "27.99",
//                null
//        ));
//
//        System.out.println("Creating User...");
//        User testUser = new User("0000", "Test User", userExpense);
//        //userRepository.save(testUser);
//
//        return testUser;
//
//    }
//
//}
