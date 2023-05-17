package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        logger.warn(name);
        return "Hello, " + name + "!";
    }
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register"; // Returns the register.html template
    }


    @PostMapping("/login")
    public void receiveValueFromFrontend(@RequestBody Login login) {
        String email = login.getEmail();
        String password = login.getPassword();
        // Process the value received from the frontend in your Java backend
        logger.warn(("Value received from the frontend: " + email + " " + password));
    }

}
