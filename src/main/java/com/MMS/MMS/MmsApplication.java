package com.MMS.MMS;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.LiabilityType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.model.*;
import com.MMS.MMS.repository.UserRepository;
import com.MMS.MMS.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableMongoRepositories
public class MmsApplication implements CommandLineRunner{

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MmsApplication.class, args);



	}

	public void run(String... args){
		createUser();
	}

	@Bean
	User createUser() {
        ArrayList<Expense> userExpense = new ArrayList<Expense>();
		userExpense.add(new Expense(
				"Test Expense",
				"20.00",
				1,
				1,
                null,
				ExpenseType.UTILITY,
				PaymentStatus.UNPAID,
				"0",
				30,
				"Test expense. Added to database from java"
		));
		userExpense.add(new Liability(
				"Test Liability",
				"45.00",
				1,
				15,
				null,
				ExpenseType.LIABILITY,
				PaymentStatus.UNPAID,
				"15.00",
				0,
				"Test Liability. Added to database from java",
				"500",
				LiabilityType.CREDITCARD,
				"5.95"
		));
		userExpense.add(new InstallmentLoan(
				"Test Installment Loan",
				"150.00",
				1,
				26,
				null,
				ExpenseType.LIABILITY,
				PaymentStatus.UNPAID,
				"45.00",
				2,
				"Test Installment Loan. Added to database from java",
				"2500",
				LiabilityType.INSTALLMENTLOAN,
				"27.99",
				null
		));

		System.out.println("Creating User...");
		User testUser = new User("0000", "Test User", userExpense);
		userRepository.save(testUser);

		return testUser;

	}

}
