package com.example.demo.service;

import com.example.demo.model.Greeting;
import com.example.demo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import java.util.List;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;

   

    public Greeting getGreetingMessage(String type) {
        switch (type.toLowerCase()) {
            case "post":
                return new Greeting(0, "Hello from POST (Via service)");
            case "put":
                return new Greeting(0, "Hello from PUT (Via service)");
            case "delete":
                return new Greeting(0, "Hello from DELETE (Via service)");
            default:
                return new Greeting(0, "Hello from GET (Via service)");
        }
    }
  //uc3
    public Greeting getPersonalizedGreeting(String firstName, String lastName) {
            String message;

            if (firstName != null && lastName != null) {
                message = "Hello, " + firstName + " " + lastName + "!";
            } else if (firstName != null) {
                message = "Hello, " + firstName + "!";
            } else if (lastName != null) {
                message = "Hello, Mr/Ms. " + lastName + "!";
            } else {
                message = "Hello World";
            }

            return new Greeting(0, message);
        }
  //uc4
    public Greeting save(Greeting greeting) {
            return greetingRepository.save(greeting);
        }
  //uc5

    public Greeting findById(long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Greeting not found"));
    }

  //uc6

      public List<Greeting> findAll() {
          return greetingRepository.findAll();
      }



}

   