package com.example.springboot;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean()
    public Test test1() {
        return new Test("The First Bean");
    }

    @Bean()
    public Test test2() {
        return new Test("The Second Bean");
    }
}
