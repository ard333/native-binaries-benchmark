package com.ard333.springvsquarkus.springgraalnative;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(proxyBeanMethods = false)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
