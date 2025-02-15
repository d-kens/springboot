package com.example.springboot;

import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    @GetMapping("/hello")
    public String sayHello(@RequestParam(value = "user-name", required = false, defaultValue = "Guest") String name) {
        return "Hello, " + name + "! Welcome to the Spring Boot Application.";
    }

    @GetMapping("/hello/{user-name}")
    public String patVar(
          @PathVariable("user-name") String userName
    ) {
        return "Hello " + userName + ". Welcome on board!!!" ;
    }

    @PostMapping("/post")
    public String post(@RequestBody String message) {
        return "Request accepted. The message is " + message;
    }

    @PostMapping("/post-order")
    public String post(
            @RequestBody Order order
    ) {
        return "Request accepted and the order is: " + order.toString();
    }

    @PostMapping("/post-order-record")
    public String postOrderRecord(
            @RequestBody OrderRecord order
    ) {
        return "Request accepted and the order is: " + order.toString();
    }

}
