package com.example.demoservice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/loadbalanced/hello")
    public String hello() {
        return "Hello from PORT 8083 (demo-service-2)";
    }
}
