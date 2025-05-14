package com.example.springboot;


import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {

    @GetMapping("/hello")
    public String sayHello(
            @RequestParam(name = "user-name", required = false) String queryParam
    ) {
        if (queryParam != null) {
            return "Hello " + queryParam;
        }

        return "Hello World";
    }

    @PostMapping("/hello")
    public String post(@RequestBody String message) {
        return "Request accepted and message is " + message;
    }

    @PostMapping("/hello/order")
    public String postOrder(@RequestBody Order order) {
        return "Request accepted and message is " + order.toString();
    }

    @PostMapping("/hello/order-record")
    public String postOrderRecord(@RequestBody OrderRecord orderRecord) {
        return "Request accepted and message is " + orderRecord.toString();
    }

    @GetMapping("/hello/{name}")
    public String pathVariable(
            @PathVariable("name") String userName
    ) {
        return "The URL Param passed is: " + userName;
    }
}
