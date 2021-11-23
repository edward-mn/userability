package com.spring.userability;

import com.spring.userability.utils.FakeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UsersAbilityApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UsersAbilityApplication.class, args);
	}

	@Autowired
	FakeData fakedata;

	@Override
	public void run(String... args) throws Exception {
		fakedata.savePosts();
	}


}
