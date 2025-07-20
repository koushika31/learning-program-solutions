package com.example.demoservice1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/loadbalanced/hello")
    public String hello() {
        return "Hello from PORT 8082 (demo-service-1)";
    }
}
