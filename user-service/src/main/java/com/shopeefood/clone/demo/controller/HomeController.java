package com.shopeefood.clone.demo.controller;

import com.shopeefood.clone.demo.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private Environment env;

    @Autowired
    AppUserRepository appUserRepository;

    @GetMapping("/hello")
    public String home() {
        // This is useful for debugging
        // When having multiple instance of gallery service running at different ports.
        // We load balance among them, and display which instance received the request.
		appUserRepository.findAll().forEach(System.out::println);
        return "Hello from User Service running at port: " + env.getProperty("local.server.port");
    }
}
