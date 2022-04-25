package com.mongobasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mongobasics")
public class MongoBasics {
	public static void main(String[] args) {
		SpringApplication.run(MongoBasics.class, args);
	}

}
