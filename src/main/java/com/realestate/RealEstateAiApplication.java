package com.realestate;

import com.realestate.payload.JwtTokenProvider;
import com.realestate.util.EmailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableScheduling
public class RealEstateAiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealEstateAiApplication.class, args);
	}



}
