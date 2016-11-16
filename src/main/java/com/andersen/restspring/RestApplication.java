package com.andersen.restspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.andersen")
public class RestApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
}
