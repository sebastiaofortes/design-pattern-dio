package com.sebastiaofortes.security.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SecurityApplication {
	



	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	System.out.println("INSERT INTO USUA VALUES (1, '"+new BCryptPasswordEncoder().encode("123")+"', 'sebastiaofortes4@gmail.com');");

		
	}

}
