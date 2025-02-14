package com.example.springboot;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean()
    public Test test() {
        return new Test("Dickens as a variable");
    }
}
