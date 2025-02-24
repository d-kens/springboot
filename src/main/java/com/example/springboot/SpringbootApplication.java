package com.example.springboot;

import com.example.springboot.basics.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication {

	public static void main(String[] args) {

		var application = new SpringApplication(SpringbootApplication.class);

//		application.setDefaultProperties(Collections.singletonMap("spring.profiles.active", "prod"));

		var applicationContext = application.run(args);

		TestService testService = applicationContext.getBean(TestService.class);
		System.out.println(testService.tellAStory());
		System.out.println(testService.getJavaVersion());
		System.out.println(testService.getOsName());
		System.out.println(testService.getProperty());
		System.out.println(testService.getCustomProperty());
		System.out.println(testService.getCustomProperty2());
	}

}
