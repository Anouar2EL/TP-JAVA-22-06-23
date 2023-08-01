package com.inetum.appliSpringWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppliSpringWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppliSpringWebApplication.class, args);
	
		System.err.println("http://localhost:8080/appliSpringWeb");
	}

}