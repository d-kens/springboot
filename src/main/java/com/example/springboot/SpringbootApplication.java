package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {

		var applicationContext = SpringApplication.run(SpringbootApplication.class, args);

		TestService testService = applicationContext.getBean(TestService.class);
		System.out.println(testService.tellAStory());
	}

}
