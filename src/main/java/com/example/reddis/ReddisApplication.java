package com.example.reddis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ReddisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReddisApplication.class, args);
	}

}
