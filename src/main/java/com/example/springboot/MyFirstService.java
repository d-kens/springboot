package com.example.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MyFirstService {

    // constructor injection
    private final MyFirstClass myFirstClass;
    public MyFirstService(MyFirstClass myFirstClass) {
        this.myFirstClass = myFirstClass;
    }

    public String tellStory() {
        return "The dependency is saying " + myFirstClass.sayHello();
    }




    //    Field Dependency Injection
//    @Autowired
//    @Qualifier("mySecondBean")
//    private MyFirstClass myFirstClass;


    // Method injection
//    private MyFirstClass myFirstClass;
//
//    @Autowired
//    public void injectDependencies(
//           @Qualifier("mySecondBean") MyFirstClass myFirstClass
//    ) {
//        this.myFirstClass = myFirstClass;
//    }

    // Setter Injection
//    private MyFirstClass myFirstClass;
//
//    @Autowired
//    public void setMyFirstClass(
//            MyFirstClass myFirstClass
//    ) {
//        this.myFirstClass = myFirstClass;
//    }
}
