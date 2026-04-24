package com.simplify.restservices.controllers;

import com.simplify.restservices.entities.User;
import com.simplify.restservices.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Long id) {
        return this.userService.getUserById(id);
    }

    @PostMapping("/users")
    public User crateUser(@RequestBody User user) {
        return this.userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return this.userService.updateUserById(id, user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Long id) {
        this.userService.deleteUserById(id);
    }

    @GetMapping("/users/byusername/{username}")
    public User findByUsername(@PathVariable String username) {
        return this.userService.findUserByUsername(username);
    }
}
