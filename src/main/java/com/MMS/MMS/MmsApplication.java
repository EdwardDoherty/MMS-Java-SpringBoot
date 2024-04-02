package com.MMS.MMS;

import com.MMS.MMS.repository.DummyDatabase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsApplication.class, args);

		// new DummyDatabase();

	}

}
