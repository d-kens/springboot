package com.example.springboot.basics;


public class Test {

    private String var;

    public Test(String var) {
        this.var = var;
    }

    public String hello() {
        return "Hello form the test class " + var;
    }
}
