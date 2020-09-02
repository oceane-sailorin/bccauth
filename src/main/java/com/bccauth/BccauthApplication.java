package com.bccauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@EnableConfigServer
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class BccauthApplication {

	public static void main(String[] args) {
		SpringApplication.run(BccauthApplication.class, args);
	}

}


