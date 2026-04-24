package com.simplify.restservices.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET, path = "/helloworld")
    public String helloWorld() {
        return "Hola mundo MUNDIALISTA!!🥅🥅🥅";
    }

    @GetMapping("/bean")
    public UserDetails getBean() {
        return new UserDetails("Cheko", "Perez", "Guadalajara");
    }
}
