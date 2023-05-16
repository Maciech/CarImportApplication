package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    private static final Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        logger.info(name);
        return "Hello, " + name + "!";
    }

}
