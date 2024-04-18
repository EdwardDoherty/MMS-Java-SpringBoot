package com.MMS.MMS.dto;

import com.MMS.MMS.enums.ChargeFrequency;
import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseCreationDTO(
        @Id
        ObjectId expenseID,
        ObjectId userID,
        String name,
        BigDecimal charge,
        ChargeFrequency chargeFrequency,
        ExpenseType expenseType,
        PaymentStatus paymentStatus,
        String notes,
        BigDecimal lateFee,
        int gracePeriod,
        int dueDate,
        LocalDate startDate,
        LocalDate endDate,
        BigDecimal totalBalance,
        BigDecimal interestRate
        ) {


}
