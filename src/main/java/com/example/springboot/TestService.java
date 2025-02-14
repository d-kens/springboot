package com.example.springboot;


import org.springframework.stereotype.Service;

@Service
public class TestService {

    private final Test test;

    public TestService(Test test) {
        this.test = test;
    }

    public String tellAStory() {
       return "The dependency is saying " + test.hello();
    }

}
