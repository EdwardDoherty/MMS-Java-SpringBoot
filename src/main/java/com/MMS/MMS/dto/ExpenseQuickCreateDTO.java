package com.MMS.MMS.dto;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

public record ExpenseQuickCreateDTO(
        @Id
        ObjectId expenseID,
        ObjectId userID,
        String name,
        BigDecimal charge,
        String notes
    ) {

}
