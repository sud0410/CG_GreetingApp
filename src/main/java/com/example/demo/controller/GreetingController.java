package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.service.GreetingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
    
    @Autowired
    private GreetingService greetingService;

    @GetMapping
    public Greeting getGreeting() {
        return greetingService.getGreetingMessage("get");
    }

    @PutMapping
    public Greeting putGreeting() {
        return greetingService.getGreetingMessage("put");
    }

    @PostMapping
    public Greeting postGreeting() {
        return greetingService.getGreetingMessage("post");
    }

    @DeleteMapping
    public Greeting deleteGreeting() {
        return greetingService.getGreetingMessage("delete");
    }
    @GetMapping("/custom")
    public Greeting getCustomGreeting(@RequestParam(required = false) String firstName,
                                      @RequestParam(required = false) String lastName) {
        return greetingService.getPersonalizedGreeting(firstName, lastName);
    }
//uc3
    @PostMapping("/save")
    public Greeting saveGreeting(@RequestBody Greeting greeting) {
        return greetingService.save(greeting);
    }
//Uc4

    @GetMapping("/{id}")
    public Greeting getGreetingById(@PathVariable long id) {
        return greetingService.findById(id);
    }
//uc5




}