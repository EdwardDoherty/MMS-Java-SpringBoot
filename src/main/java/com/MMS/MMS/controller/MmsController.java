package com.MMS.MMS.controller;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.LiabilityType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.model.Date;
import com.MMS.MMS.model.Expense;
import com.MMS.MMS.model.InstallmentLoan;
import com.MMS.MMS.model.Liability;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class MmsController {

    //Home Page
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("testExpense", new Expense(
                "Test Expense",
                new BigDecimal("20.00"),
                1,
                new Date(1),
                new Date(0),
                ExpenseType.UTILITY,
                PaymentStatus.UNPAID,
                new BigDecimal("25"),
                2,
                "Test Bill. These are the notes"
        ));

        model.addAttribute("testLiability", new Liability(
                "Test Liability",
                new BigDecimal("20.00"),
                1,
                new Date(1),
                new Date(0),
                ExpenseType.LIABILITY,
                PaymentStatus.UNPAID,
                new BigDecimal("25"),
                2,
                "Test Bill. These are the notes",
                new BigDecimal("500"),
                LiabilityType.CREDITCARD,
                new BigDecimal("5")
        ));

        model.addAttribute("testInstallment", new InstallmentLoan(
                "Test Installment",
                new BigDecimal("20.00"),
                1,
                new Date(1),
                new Date(0),
                ExpenseType.LIABILITY,
                PaymentStatus.UNPAID,
                new BigDecimal("25"),
                2,
                "Test Bill. These are the notes",
                new BigDecimal("500"),
                LiabilityType.INSTALLMENTLOAN,
                new BigDecimal("5"),
                new Date(30)
        ));
        return "homePage";
    }

    @GetMapping(value = "/thymeleafTemplate")
    public String getTemplate(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "thymeleafTemplate";
    }

}
