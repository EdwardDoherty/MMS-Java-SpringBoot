package com.MMS.MMS;

import java.util.ArrayList;
import java.util.List;

import com.MMS.MMS.enums.ExpenseType;
import com.MMS.MMS.enums.PaymentStatus;
import com.MMS.MMS.model.*;
import com.MMS.MMS.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableMongoRepositories
public class MmsApplication implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(MmsApplication.class, args);


	}

	@Override
	public void run(String... args){
		userRepository.deleteAll();

		userRepository.save(new User("0001","User 1", new ArrayList<Expense>()));
		userRepository.save(new User("0002","User 2", new ArrayList<Expense>()));

		for(User user : userRepository.findAll()) {
			System.out.println(user);
		}

		System.out.println(userRepository.findUserByUserName("User 1"));

		User billyEyelash = userRepository.findUserByUserName("User 1");
		billyEyelash.setUserName("Billy Eyelash");

		userRepository.save(billyEyelash);

		for(User user : userRepository.findAll()) {
			System.out.println(user);
		}



	}



}
