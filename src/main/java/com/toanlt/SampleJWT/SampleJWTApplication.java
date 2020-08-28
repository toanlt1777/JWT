package com.toanlt.SampleJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.toanlt.SampleJWT.controller.JWTController;
import com.toanlt.SampleJWT.model.User;
import com.toanlt.SampleJWT.responsitory.UserRepository;

@SpringBootApplication
public class SampleJWTApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SampleJWTApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	@Override
	public void run(String... args) throws Exception {
		// Insert vào csdl một user.
		User user = new User();
		user.setUsername("toanlt");
		user.setPassword(passwordEncoder.encode("12345"));
		userRepository.save(user);
		System.out.println(user);
	}
}
