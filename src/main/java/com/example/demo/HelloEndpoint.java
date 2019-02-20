package com.example.demo;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class HelloEndpoint {

    @GetMapping("/admin/hello")
    @Secured("ROLE_ADMIN")
    public String sayHelloToAdmin(final Principal principal) {
        return "Hello Admin: " + principal.getName();
    }

    @GetMapping("/user/hello")
    @Secured("ROLE_USER")
    public String sayHelloToUser(final Principal principal) {
        return "Hello User: " + principal.getName();
    }

    @GetMapping("/guest/hello")
    public String sayHelloToGuest() {
        return "Hello Guest";
    }

}
