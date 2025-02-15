package com.example.springboot;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfig {

    @Bean()
    @Profile("dev")
    public Test test1() {
        return new Test("The First Bean");
    }

    @Bean()
    @Profile("prod")
    public Test test2() {
        return new Test("The Second Bean");
    }
}
